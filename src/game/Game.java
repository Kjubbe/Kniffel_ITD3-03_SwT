package game;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;

import database.PlayerManagement;
import view.EndDialogView;

/**
 * a game instance manages the game and their players
 * 
 * @author Kjell Treder
 *
 */

public class Game {

    /**
     * toggles the use of autofill. if autofill is enabled, all fields on the card
     * are filled with values to choose from
     */
    public final boolean useAutofill;

    /**
     * toggles the use of auto calculation. if auto calculation is enabled, the
     * chosen field calculates its value automatically
     */
    public final boolean useAutocalc;

    private final int maxGames; // max number of games to be played
    private final int gamesToWin; // max number of games to be won to win the whole game

    public final List<Player> players; // contains all participating players
    private final Player[] seats = new Player[PlayerManagement.MAX_PLAYERS];

    private Player currentPlayer; // the current player doing his turn
    private int playerIndex; // index of the current player
    private Player winner; // winner of the game

    /**
     * array of dice for rolling
     */
    public static final Die[] DICE = { new Die(), new Die(), new Die(), new Die(), new Die() };
    public static final int MAX_ROLLS = 3;
    private final int[] diceValues = new int[DICE.length];
    private int rolls;

    public static final int MAX_ROUNDS = 3; // TODO change
    private int roundsPlayed;
    private int gamesPlayed;

    /**
     * Constructor, defines the name, a password, the usage of the assistant, max
     * players, max Games, games to win and the host.
     * 
     * @param autofill if using autofill
     * @param autocalc if using autocalc
     * @param maxGames number of max games
     * @param players  players on the server
     */
    public Game(boolean autofill, boolean autocalc, int maxGames, List<Player> players) {
        this.useAutofill = autofill;
        this.useAutocalc = autocalc;
        this.maxGames = maxGames;
        this.gamesToWin = maxGames;
        this.players = players;
        this.currentPlayer = players.get(playerIndex);
        init();
    }

    /**
     * initialize the data fields
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
     * @return true if turn endet
     */
    public boolean rollDie() {

        // the turn is over if rolls is equals or more than 3
        boolean turnOver = rolls >= 3;

        // roll all die if the game is not over
        if (!turnOver) {
            for (Die d : DICE) { // roll the die
                if (d.roll()) { // each rolled die increases the dice rolled in the stats
                    currentPlayer.getStats().increaseDiceRolled();
                }
            }
            rolls++; // increase the roll counter

            // get the values of the dice
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
    public void nextPlayer() {
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
        // first, check if someone has won enough games
        boolean done = false;
        for (Player p : players) {
            if (p.getWins() >= gamesToWin) {
                done = true;
                break;
            }
        }
        // second, check if there are enough games played
        boolean over = done || gamesPlayed >= maxGames;
        System.out.println("Checking if game is over: " + over);
        return over;
    }

    /**
     * find the winner of the game
     */
    public void findWinner() {
        winner = players.get(0); // first player is the winner

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
     * remove a player from the server
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
     * remove a player from the server
     * 
     * @param player player, who is removed
     * @return if the removing was successful or not
     */
    public boolean skipPlayer(Player player) {
        boolean result = player == currentPlayer;
        if (result) { // only the current player can be skipped
            currentPlayer.getCard().setToZero(); // reset the players card
            nextPlayer(); // go to the next player
        }
        return result;
    }

    /**
     * choose a field
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
     * choose a field and its value
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
     * cross a field
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
     * get a player from the list at an index
     * 
     * @param index the index of the player in the list
     * @return the player
     */
    public Player getPlayerAt(int index) {
        return this.players.get(index);
    }
}
