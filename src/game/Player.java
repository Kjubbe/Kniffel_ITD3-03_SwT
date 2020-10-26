package game;

/**
 * Player management, contains information about the state of the player player
 * can play the game
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public class Player {

	// data fields
	protected String name;

	protected Server joinedServer;
	protected Stats myStats;
	protected Card myCard;

	protected int wins;

	/**
	 * Constructor, gives a name, assigns a stat and a card
	 * 
	 * @param name name
	 */
	public Player(String name) {
		this.name = name;
		assignCard();
	}

	/**
	 * Search for a server
	 */
	public void searchServer() {
		// TODO
	}

	/**
	 * Join a server
	 * 
	 * @param server server to be joined
	 * @return if joining was successful.
	 */
	public boolean joinServer(Server server) {
		// TODO assign the joined server
		// TODO tell the server that the player joined
		return false;
	}

	/**
	 * Assign stats to this player
	 * 
	 * @param stats Stats to be assigned
	 */
	public final void assignStats(Stats stats) {
		this.myStats = stats;
	}

	/**
	 * Assign stats to this player
	 */
	public final void assignStats() {
		this.myStats = new Stats(this);
	}

	/**
	 * Increase number of wins
	 */
	public void increaseWins() {
		this.wins++;
	}

	/**
	 * Assign a card to a player
	 */
	public final void assignCard() {
		this.myCard = new Card(this);
	}

	/**
	 * Getter for the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the stats
	 * 
	 * @return stats
	 */
	public Stats getStats() {
		return myStats;
	}

	/**
	 * Getter for the card
	 * 
	 * @return card
	 */
	public Card getCard() {
		return myCard;
	}

	/**
	 * Getter for the points
	 * 
	 * @return total points
	 */
	public int getPoints() {
		return myCard.getTotal();
	}

	/**
	 * Getter for the amount of wins
	 * 
	 * @return total points
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * Getter for the amount of open fields
	 * 
	 * @return total points
	 */
	public int getOpenFields() {
		return myCard.getOpenFields();
	}

	/**
	 * Make your turn
	 */
	protected void makeTurn() {
		// TODO create die for the player
		// TODO roll all die
		// TODO wait for user input to choose dice or roll again
		// TODO end turn
	}

	/**
	 * End your turn
	 * 
	 * @param dice[] array of the dices
	 */
	protected void endTurn(Die[] dice) {
		// TODO show the card
		// TODO choose or cross a field
	}

	/**
	 * Choose dice
	 * 
	 * @param dice Players dice
	 * @return if player wants to roll again
	 */
	protected boolean chooseDice(Die[] dice) {
		// TODO toggle the state of the die based on user input
		return false;
	}

	/**
	 * Choose a field to fill
	 * 
	 * @param result Value of the dice
	 */
	protected void chooseField(Integer[] result) {
		// TODO choose or cross fields based on user input
	}

	/**
	 * Choose a field to cross
	 */
	protected void crossField() {
		// TODO cross fields based on user input
	}
}