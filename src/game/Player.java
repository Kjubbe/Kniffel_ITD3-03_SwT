package game;

/**
 * Player management, contains information about the state of the player player
 * can play the game
 * 
 * @author Kjell Treder
 *
 */

public class Player {

	// data fields
	protected String name;
	protected boolean saveStats;

	protected Game myGame;
	protected Stats myStats;
	protected Card myCard = new Card(this);

	protected int wins;

	/**
	 * Constructor, gives a name, assigns a stat and a card
	 * 
	 * @param name name
	 */
	public Player(String name) {
		this.name = name;
		assignStats();
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * invoke to save the players stats
	 */
	public void saveStats() {
		saveStats = true;
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
	 * Assign stats to this player TODO remove, this is for testing purposes
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
	 * check if player wants to save their stats
	 * 
	 * @return if saving stats
	 */
	public boolean isSavingStats() {
		return saveStats;
	}
}
