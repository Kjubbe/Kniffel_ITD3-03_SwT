package game;

/**
 * This class manages the actions of the host, inherits from player
 * 
 * @author Kjell Treder
 *
 */

public class Host extends Player {

	/**
	 * Constructor, calls super constructor to set the name
	 * 
	 * @param name name
	 */
	public Host(String name) {
		super(name);
	}

	/**
	 * Search for a server, a host can not search for a server
	 */
	@Override
	public void searchServer() {
		// Host can not search for a server.
		// TODO remove this, since there is only local support
	}

	/**
	 * Create a server
	 */
	public void createServer() {
		// TODO create a server and assign it to "joinedServer"
		// TODO make the server public
	}

	/**
	 * Start the game
	 */
	public void startGame() {
		myGame.play();
	}

	/**
	 * Pause the game
	 */
	public void pauseGame() {
		// TODO pause game method
	}

	/**
	 * Stop the game
	 */
	public void stopGame() {
		//
	}

	/**
	 * Restart the game
	 */
	public void restartGame() {
		//
	}

	/**
	 * Skip the turn of a player
	 */
	public void skipCurrentPlayer() {
		// TODO skip player method
	}

	/**
	 * remove a player from the server
	 * 
	 * @param player player to be removed
	 */
	public void removePlayer(Player player) {
		myGame.removePlayer(player);
	}

}