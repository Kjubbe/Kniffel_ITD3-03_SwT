package game;

import java.util.ArrayList;
import java.util.List;

/**
 * the server list holds all servers
 * TODO remove this, since there is only local support
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public final class Serverlist {

	private static final List<Server> servers = new ArrayList<>();

	/**
	 * private constructor, because this class is not meant to be instantiated
	 * 
	 * @throws IllegalStateException when instantiating this class
	 */
	private Serverlist() {
		throw new IllegalStateException("This Utility class is not meant to be instantiated");
	}

	/**
	 * Put the server on the server list
	 * 
	 * @param g server
	 */
	public static void makePublic(Server g) {
		if (!servers.contains(g)) {
			servers.add(g); // Add Game to List of Games
		}
	}

	/**
	 * Get all servers on the server list
	 * 
	 * @return List of all the servers
	 */
	public static List<Server> getServers() {
		return servers;
	}
}