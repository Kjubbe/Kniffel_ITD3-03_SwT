package game;

import java.util.LinkedList;
import java.util.List;

/**
 * a server instance manages the game and their players
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public class Game {

	// data fields
	private final boolean useAssistant; // Toggle the use of an Assistant
	private boolean gameIsDone; // Is the game done?
	private final int maxPlayers; // max number of players able to join
	private final int maxGames; // max number of games to be played
	private final int gamesToWin; // max number of games to be won to win the whole game

	private int roundNr = 1;

	private final List<Player> players;
	private Player currentPlayer;

	public static Die[] dice = { new Die(0), new Die(1), new Die(2), new Die(3), new Die(4) };

	/**
	 * Constructor, defines the name, a password, the usage of the assistant, max
	 * players, max Games, games to win and the host.
	 * 
	 * @param a       if using assistant
	 * @param max     number of max players
	 * @param maxG    number of max games
	 * @param win     amount of games needed to win
	 * @param players players on the server
	 */
	public Game(boolean a, int max, int maxG, int win, List<Player> players) {
		this.useAssistant = a;
		this.maxPlayers = max;
		this.maxGames = maxG;
		this.gamesToWin = win;
		this.players = players;
	}

	/**
	 * Add Player to the server
	 * 
	 * @param p  Player, who is added to the server
	 * @return if the adding was successful or not
	 */
	public boolean addPlayer(Player p) {
		boolean result = false;
		if (players.size() < maxPlayers) {
			players.add(p);
			result = true;
		}
		return result;
	}

	/**
	 * Play the game
	 */
	public void play() {
		for (int i = 0; i < maxGames; i++) {
			for (Player p : players) {
				if (p.wins >= gamesToWin) {
					findWinner();
					return;
				}
			}
			
			for (Player p : players) {
				p.makeTurn();
			}
		}
	}

	/**
	 * roll all die
	 */
	public void rollDie() {
		for (Die d : dice) {
			d.roll();
		}
	}

	/**
	 * end your turn
	 */
	public void endTurn() {
		//
	}

	/**
	 * Find the winner of the game
	 */
	public void findWinner() {
		Player winner = players.get(0);
		for (Player p : players) {
			int points = p.getPoints();
			if (points > winner.getPoints()) {
				winner = p;
			}
		}
	}

	/**
	 * Reset, so another game can be played
	 */
	public void reset() {
		for (Player p : players) {
			p.assignCard();
		}
	}

	/**
	 * restart the game
	 */
	public void restart() {
		//
	}

	/**
	 * stop the game
	 */
	public void stop() {
		// TODO show how many wins each player had
	}

	/**
	 * pause the game
	 */
	public void pause() {

	}

	/**
	 * Remove a player from the server
	 * 
	 * @param other Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean removePlayer(Player other) {
		return players.remove(other);
	}
  
	/**
	 * Remove a player from the server
	 * 
	 * @param other Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean skipPlayer(Player other) {
		// 
	}
}