package game;

/**
 * Class for menu management
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public final class Menu {

	/**
	 * private constructor, because this class is not meant to be instantiated
	 * 
	 * @throws IllegalStateException when instantiating this class
	 */
	private Menu() {
		throw new IllegalStateException("This Utility class is not meant to be instantiated");
	}

	/**
	 * Player can login with password and account name
	 * 
	 * @param name account name
	 * @param pw   password
	 * @return if login was successful
	 */
	public static boolean login(String name, String pw) {
		// TODO
		return true;
	}

	/**
	 * Player can register with password, email and account name
	 * 
	 * @param name  account name
	 * @param email email address
	 * @param pw    password
	 * @return if login was successful
	 */
	public static boolean register(String name, String email, String pw) {
		// TODO
		return true;
	}

	/**
	 * the user can continue as a guest
	 * 
	 * @param name player name
	 */
	public static void playAsGuest(String name) {
		// TODO
	}

	/**
	 * the user wants to join a game
	 */
	public static void bePlayer() {
		// TODO remove this, since there is only local support
	}

	/**
	 * the user wants to host a game
	 */
	public static void beHost() {
		// TODO remove this, since there is only local support
	}

}