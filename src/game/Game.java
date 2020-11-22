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
	 * @param pw password input of the player // TODO remove pw
	 * @return if the adding was successful or not
	 */
	public boolean addPlayer(Player p, String pw) { // TODO remove pw
		// TODO check the password and if the maximum player count has not been reached
		return false;
	}

	/**
	 * End the server
	 */
	public void endServer() {
		// TODO show how many wins each player had
	}

	/**
	 * Play the game
	 */
	public void play() {
		// TODO start the game
		// TODO let each player do their turns
		// TODO repeat until no players have any open fields
		// TODO find a winner
		// TODO restart the game until all games are played
		// TODO end the server
	}

	/**
	 * Find the winner of the game
	 */
	private void findWinner() {
		// TODO
	}

	/**
	 * Reset, so another game can be played
	 */
	private void reset() {
		// TODO reassign new cards for every player
	}

	/**
	 * Restart the server.
	 */
	public void restartServer() {
		reset();
		play();
	}

	/**
	 * Remove a player from the server
	 * 
	 * @param other Player, who is removed
	 * @return if the removing was successful or not
	 */
	public boolean removePlayer(Player other) {
		// TODO
		return false;
	}
}
