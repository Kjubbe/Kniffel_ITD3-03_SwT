package game;

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

	private final List<Player> players; // contains all participating players
	public Player currentPlayer;
	public Player winner;
	private int playerIndex;

	public static final Die[] DICE = { new Die(), new Die(), new Die(), new Die(), new Die() };
	private int[] diceValues;
	public static final int MAX_ROLLS = 3;

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
		this.maxGames = (gamesToWin - 1) * players.size();
		this.gamesToWin = gamesToWin;
		this.players = players;
		this.currentPlayer = players.get(playerIndex);
	}

	/**
	 * roll all die
	 * 
	 * @return true if turn endet
	 */
	public boolean rollDie() {
		boolean turnOver = rolls >= 3;
		if (!turnOver) {
			for (Die d : DICE) {
				d.roll();
			}
			rolls++;

			turnOver = rolls >= 3;
			if (turnOver) {
				endTurn();
			}
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
		if (players.size() - 1 > playerIndex) {
			playerIndex = 0;
			roundsPlayed++;
		}
		if (roundsPlayed >= MAX_ROUNDS) {
			findWinner();
			return true;
		} else {
			currentPlayer = players.get(playerIndex);
		}
		return false;
	}

	/**
	 * get to the next game
	 * 
	 * @return true if this was the last game
	 */
	public boolean nextGame() {
		boolean done = false;
		for (Player p : players) {
			if (p.getWins() >= gamesToWin) {
				done = true;
				break;
			}
		}
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
			diceValues[i] = DICE[i].getValue();
		}
		currentPlayer.getCard().calculatePoints(diceValues);
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
	 * Remove a player from the server
	 * 
	 * @param other Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean removePlayer(Player other) {
		if (other == currentPlayer) {
			skipPlayer(other);
		}
		return players.remove(other);
	}

	/**
	 * Remove a player from the server
	 * 
	 * @param other Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean skipPlayer(Player other) {
		boolean result = other == currentPlayer;
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