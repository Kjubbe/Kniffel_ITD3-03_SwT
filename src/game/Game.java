package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public Player currentPlayer; // the current player doing his turn
	private int playerIndex; // index of the current player
	public Player winner; // winner of the game

	/**
	 * array of dice for rolling
	 */
	public static final Die[] DICE = { new Die(), new Die(), new Die(), new Die(), new Die() };
	public static final int MAX_ROLLS = 3;
	private int[] diceValues;
	public int rolls;

	public static final int MAX_ROUNDS = Card.FIELD_NAMES.length;
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
	}

	/**
	 * Constructor, defines the name, a password, the usage of the assistant, max
	 * players, max Games, games to win and the host.
	 * 
	 * @param autofill   if using autofill
	 * @param autocalc   if using autocalc
	 * @param gamesToWin amount of games needed to win
	 * @param players    players on the server
	 */
	public Game(boolean autofill, boolean autocalc, byte gamesToWin, List<Player> players) {
		this.useAutofill = autofill;
		this.useAutocalc = autocalc;
		this.maxGames = (gamesToWin - 1) * players.size(); // the maximum amount of games is calculated
		this.gamesToWin = gamesToWin;
		this.players = players;
		this.currentPlayer = players.get(playerIndex);
	}

    public Game() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/**
	 * roll all die
	 * 
	 * @return true if turn endet
	 */
	public boolean rollDie() {
		boolean turnOver = rolls >= 3;
		if (!turnOver) {
			for (Die d : DICE) { // roll the die when the turn is not over
				d.roll();
			}
			rolls++;
                        diceValues = new int[DICE.length];
                        for (int i = 0; i < diceValues.length; i++) {
                            diceValues[i] = DICE[i].getValue(); // set each value in the array
                        }
                        currentPlayer.getCard().calculatePoints(diceValues); // calculate the values for the fields
		}
		return turnOver;
	}
        
        

	/**
	 * get to the next player
	 * 
	 * @return true if game is over
	 */
	public boolean nextPlayer() {
		playerIndex++;
		rolls = 0;
		if (players.size() - 1 < playerIndex) { // check if there is another player
			playerIndex = 0; // loop around
			roundsPlayed++;
		}
		if (roundsPlayed >= MAX_ROUNDS) { // check if all rounds have been played
			findWinner(); // find a winner
			return true;
		} else { // there are more rounds
			currentPlayer = players.get(playerIndex); // set the next player
		}
		return false;
	}

	/**
	 * get to the next game
	 * 
	 * @return true if this was the last game
	 */
	public boolean nextGame() {
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
		if (!over) {
			restart();
		} else {
			findWinner(); // TODO
		}
		return over;
	}

	/**
	 * ends the current players turn
	 */
	public void endTurn() {
		diceValues = new int[DICE.length];
		for (int i = 0; i < diceValues.length; i++) {
			diceValues[i] = DICE[i].getValue(); // set each value in the array
		}
		currentPlayer.getCard().calculatePoints(diceValues); // calculate the values for the fields
	}

	/**
	 * find the winner of the game
	 */
	public void findWinner() {
		winner = players.get(0);
		for (Player p : players) {
			int points = p.getPoints();
			if (points > winner.getPoints()) {
				winner = p;
			}
			// TODO tie
		}
		winner.increaseWins();
		nextGame();
	}

	/**
	 * restart the game
	 */
	public void restart() {
		for (Player p : players) {
			p.assignCard();
		}
		rolls = 0;
		playerIndex = -1;
		roundsPlayed = 0;
		nextPlayer();
	}

	/**
	 * remove a player from the server
	 * 
	 * @param player Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean removePlayer(Player player) {
		if (player == currentPlayer) {
			skipPlayer(player);
		}
		return players.remove(player);
	}

	/**
	 * remove a player from the server
	 * 
	 * @param player player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean skipPlayer(Player player) {
		boolean result = player == currentPlayer;
		if (result) {
			currentPlayer.getCard().setToZero();
			nextPlayer();
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
		nextPlayer();
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
		nextPlayer();
		return result;
	}
}
