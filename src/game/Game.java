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

	public Player currentPlayer; // the current player doing his turn
	private int playerIndex; // index of the current player
	public Player winner; // winner of the game

	/**
	 * array of dice for rolling
	 */
	public static final Die[] DICE = { new Die(), new Die(), new Die(), new Die(), new Die() };
	public static final int MAX_ROLLS = 3;
	private final int[] diceValues = new int[DICE.length];
	public int rolls;

	public static final int MAX_ROUNDS = 3;
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
		init();
	}

	private void init() {
		for (int i = 0; i < players.size(); i++) {
			seats[i] = players.get(i);
		}
		for (Player p : players) {
			p.getStats().startPlaying();
		}
	}

	/**
	 * roll all die
	 * 
	 * @return true if turn endet
	 */
	public boolean rollDie() {
		boolean turnOver = rolls >= 3;

		if (!turnOver) {
			for (Die d : DICE) { // roll the die
				if (d.roll()) {
					currentPlayer.getStats().increaseDiceRolled();
				}
			}
			rolls++;

			for (int i = 0; i < diceValues.length; i++) {
				diceValues[i] = DICE[i].getValue(); // set each value in the array
			}
			currentPlayer.getCard().calculatePoints(diceValues); // calculate the values for the fields
		}
		return turnOver;
	}

	/**
	 * get to the next player
	 */
	public void nextPlayer() {
		playerIndex++;
		rolls = 0;
		if (players.size() - 1 < playerIndex) { // check if there is another player
			playerIndex = 0; // loop around
			roundsPlayed++;
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
		winner = players.get(0);
		for (Player p : players) {
			int points = p.getPoints();
			if (points > winner.getPoints()) {
				winner = p;
			}
			p.getStats().increasePoints(points);
			p.getStats().increaseGamesPlayed();
		}
		winner.increaseWins();
		winner.getStats().increaseGamesWon();

		boolean gameOver = isGameOver();
		new EndDialogView(this, gameOver).setVisible(true);
		if (gameOver) {
			for (Player p : players) {
				p.getStats().stopPlaying();
			}
			PlayerManagement.getInstance().savePlayers();
		} else {
			restart();
		}
	}

	/**
	 * start the next game
	 */
	public void nextGame() {
		for (Player p : players) {
			p.wins = 0;
		}
		restart();
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
	 * @param index Index of the Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean removePlayer(int index) {
		System.out.println("removing player at seat index " + index);
		boolean result = false;
		if (players.size() > 2) {
			Player player = seats[index];
			System.out.println("current playerindex: " + playerIndex);
			int checkIndex = players.indexOf(player);
			result = players.remove(player);

			if (checkIndex <= playerIndex) {
				playerIndex--;
				System.out.println("red playerindex: " + playerIndex);
			}
			if (player == currentPlayer) {
				nextPlayer();
			}
			
		}
		System.out.println("result: " + result);
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
		if (result) {
			currentPlayer.getStats().increaseRoundsPlayed();
			nextPlayer();
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
		if (result) {
			currentPlayer.getStats().increaseRoundsPlayed();
			nextPlayer();
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
		if (result) {
			currentPlayer.getStats().increaseRoundsPlayed();
			nextPlayer();
		}
		return result;
	}
}
