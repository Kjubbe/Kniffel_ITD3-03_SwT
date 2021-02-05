package game;

import java.util.List;

import database.PlayerManagement;
import view.EndDialogView;

/**
 * a game instance manages the game and their players. each player gets their
 * turn until all rounds are played. each player can roll dice, choose and cross
 * fields. when all rounds are played a winner is chosen
 * 
 * @author Kjell Treder
 *
 */

public class Game {

    /**
     * toggles the use of autofill. if autofill is enabled, all fields on the card
     * are filled automatically with values to choose from. should autofill be
     * disabled the card will not show values
     */
    public final boolean useAutofill;

    /**
     * toggles the use of auto calculation. if auto calculation is enabled, the
     * chosen field calculates its value automatically. with no autocalculation, the
     * players need to write the values inside the table themselves
     */
    public final boolean useAutocalc;

    /**
     * contains the maximum number of games to be played
     */
    private final int maxGames;

    /**
     * contains all players in a list. the order of the list determines the order of
     * the turns. this list contains all participating players. removed players will
     * also be removed from this list
     */
    public final List<Player> players;

    /**
     * models the shown player seats in the view. each player gets a seat. the seats
     * will not change over the course of the game, removing a player only removes
     * them from the list and not this array. this is needed to manage removing
     * players correctly
     */
    private final Player[] seats = new Player[PlayerManagement.MAX_PLAYERS];

    /**
     * contains the player who is currently playing and doing his turn
     */
    private Player currentPlayer;

    /**
     * contains the index of the playing player in the list. this index is
     * incremented after each turn to switch to the next player in the list by index
     */
    private int playerIndex;

    /**
     * array of the dice. these dice get rolled each turn ans simulate the dice
     * shown in the view
     */
    public static final Die[] DICE = { new Die(), new Die(), new Die(), new Die(), new Die() };

    /**
     * maximum amount of rolls each player has
     */
    public static final int MAX_ROLLS = 3;

    /**
     * the maximum amount of rounds to be played. this value corresponds with the
     * total amount of fields on the card
     */
    public static final int MAX_ROUNDS = 2;

    /**
     * roll counter containing the amount of rolls for this turn. rolls is never >
     * MAX_ROLLS
     */
    private int rolls;

    /**
     * rounds counter containing the amount of rounds played. rounds is never >
     * MAX_ROUNDS
     */
    private int roundsPlayed;

    /**
     * games counter containing the amount of games played. games is never >
     * maxGames
     */
    private int gamesPlayed;

    /**
     * constructor, defines the usage of the assistant and autocalc, max Games and
     * all the players
     * 
     * @param autofill if using autofill for this game
     * @param autocalc if using autocalc for this game
     * @param maxGames number of max games
     * @param players  participating players
     */
    public Game(boolean autofill, boolean autocalc, int maxGames, List<Player> players) {
        this.useAutofill = autofill;
        this.useAutocalc = autocalc;
        this.maxGames = maxGames;
        this.players = players;
        this.currentPlayer = players.get(0); // first player starts
        init(); // initialize
    }

    /**
     * initialize: each player starts playing and the seats get set
     */
    private void init() {
        // fill in the seats
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            p.getStats().startPlaying(); // each player starts playing
            seats[i] = players.get(i); // put every player of the list in the seats array
        }
    }

    /**
     * roll all die
     * 
     * @return true if turn endet, otherwise false
     */
    public boolean rollDie() {

        // the turn is over if rolls is equals or more than MAX_ROLLS
        boolean turnOver = rolls >= MAX_ROLLS;

        // roll all die if the game is not over
        if (!turnOver) {
            for (Die d : DICE) { // roll the die
                if (d.roll()) { // each rolled die increases the dice rolled in the stats
                    currentPlayer.getStats().increaseDiceRolled();
                }
            }
            rolls++; // increase the roll counter

            // get the values of the dice
            int[] diceValues = new int[DICE.length];
            for (int i = 0; i < diceValues.length; i++) {
                diceValues[i] = DICE[i].getValue(); // set each value in the array
            }
            // calculate the points from the dice values
            currentPlayer.getCard().calculatePoints(diceValues); // calculate the values for the fields
        }
        return turnOver;
    }

    /**
     * get to the next player
     */
    private void nextPlayer() {
        playerIndex++; // go to the next player in the list
        rolls = 0; // reset the roll counter

        if (players.size() - 1 < playerIndex) { // check if there is another player
            playerIndex = 0; // loop around
            roundsPlayed++; // increase the rounds played
        }
        if (roundsPlayed >= MAX_ROUNDS) { // check if all rounds have been played
            findWinner(); // find a winner
        } else { // there are more rounds
            currentPlayer = players.get(playerIndex); // set the next player
        }
    }

    /**
     * check if the game is over
     * 
     * @return true if this was the last game
     */
    public boolean isGameOver() {
        System.out.println("Checking if game is over: " +  gamesPlayed + "/" + maxGames);
        return gamesPlayed >= maxGames;
    }

    /**
     * find the winner of the game
     */
    private void findWinner() {
        gamesPlayed++;
        Player winner = players.get(0); // first player is the winner

        // check all players to find the winner
        for (Player p : players) {
            int points = p.getPoints();
            if (points > winner.getPoints()) { // new winner, when points are greater than previous winner
                winner = p;
            }
            p.getStats().increasePoints(points); // increase the points in the stats
            p.getStats().increaseGamesPlayed(); // increase the games in the stats
        }
        winner.increaseWins(); // increase the wins for the winner
        winner.getStats().increaseGamesWon(); // increase the wins in the stats for the winner

        boolean gameOver = isGameOver(); // check if the game is over

        // create a new end dialog
        new EndDialogView(this, gameOver).setVisible(true);

        if (gameOver) { // when there are no more games to play, each player stops playing
            for (Player p : players) {
                p.getStats().stopPlaying();
            }

            // save the stats in the database
            PlayerManagement.getInstance().savePlayers();
        } else { // restart to play another game
            restart();
        }
    }

    /**
     * start the next game
     */
    public void nextGame() {
        for (Player p : players) {
            p.wins = 0; // reset all wins
        }
        restart(); // restart the game
    }

    /**
     * restart the game
     */
    public void restart() {
        for (Player p : players) {
            p.assignCard(); // each player gets a new card
        }
        rolls = 0; // reset the roll counter
        playerIndex = -1; // start from the first player
        roundsPlayed = 0; // reset the round counter
        nextPlayer(); // next player, which is the first
    }

    /**
     * remove a player from this game
     * 
     * @param index Index of the Player, who is removed
     * @return 0 if removing the player was not successful, 1 if removing was
     *         successful, -1 if the removed player is the current player
     */
    public int removePlayer(int index) {
        // gives information about the removed player
        int result = 0;

        // players only get removed, if there are more than two players
        if (players.size() > 2) {
            // get the player at the index
            Player player = seats[index];

            // get the index of the player in the list
            int checkIndex = players.indexOf(player);

            // try removing the player
            boolean removed = players.remove(player);

            // the mode is set to 1, if removing was successful
            result = removed ? 1 : 0;

            // should the removed player be before the playing player
            if (removed && checkIndex <= playerIndex) {
                // reduce the player index, to compensate for the removed player
                // this is needed, because otherwise a player is skipped in the next turn
                playerIndex--;
            }
            // should the removed player be the current player
            if (removed && player == currentPlayer) {
                // set the mode to -1
                result = -1;
                nextPlayer(); // get to the next player
            }

        }
        return result;
    }

    /**
     * skip a players turn. only the current player can be skipped
     * 
     * @param index index of the player, who should be skipped
     * @return if the skipping was possible
     */
    public boolean skipPlayer(int index) {
        Player player = seats[index];
        boolean result = player == currentPlayer;
        if (result) { // only the current player can be skipped
            currentPlayer.getCard().setToZero(); // reset the players card
            nextPlayer(); // go to the next player
        }
        return result;
    }

    /**
     * choose a field by index
     * 
     * @param index index of the field
     * @return if successful
     */
    public boolean chooseField(int index) {
        boolean result = currentPlayer.getCard().chooseField(index);
        if (result) { // only go to the next player, if choosing the field was successful
            currentPlayer.getStats().increaseRoundsPlayed();
            nextPlayer(); // go to the next player
        }
        return result;
    }

    /**
     * choose a field and its value by index
     * 
     * @param index index of the field
     * @param value value of the field
     */
    public boolean chooseField(int index, int value) {
        boolean result = currentPlayer.getCard().chooseField(index, value);
        if (result) { // only go to the next player, if choosing the field was successful
            currentPlayer.getStats().increaseRoundsPlayed();
            nextPlayer(); // go to the next player
        }
        return result;
    }

    /**
     * cross a field by index
     * 
     * @param index index of the field
     * @return if successful
     */
    public boolean crossField(int index) {
        boolean result = currentPlayer.getCard().crossField(index);
        if (result) { // only go to the next player, if crossing the field was successful
            currentPlayer.getStats().increaseRoundsPlayed();
            nextPlayer(); // go to the next player
        }
        return result;
    }

    /**
     * get a player from the list of participating players at an index
     * 
     * @param index the index of the player in the list
     * @return the player at that index in the list
     */
    public Player getPlayerAt(int index) {
        return this.players.get(index);
    }

    /**
     * get the player, who is currently playing
     * 
     * @return the player object
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * get the roll count
     * 
     * @return the amount of rolls
     */
    public int getRollCount() {
        return rolls;
    }
}
