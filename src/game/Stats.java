package game;

/**
 * contains all data for a player
 * 
 * @author Kjell Treder
 *
 */

public class Stats {

	// data fields
	private Player statsOf;
	private int gamesWon;
	private int gamesPlayed;
	private int roundsPlayed;
	private int points;
	private int diceRolled;
	private double timePlayed;

	/**
	 * Constructor, assigns values
	 * 
	 * @param statsOf      reference to the stats of this player
	 * @param gamesWon     count of how many games have been won
	 * @param gamesPlayed  count of how many games have been played
	 * @param roundsPlayed count of how many rounds have been played
	 * @param points       count of how many points have been acquired
	 * @param diceRolled   count of how many dice have been rolled
	 * @param timePlayed   seconds of time played
	 */
	public Stats(Player statsOf, int gamesWon, int gamesPlayed, int roundsPlayed, int points, int diceRolled,
			int timePlayed) {
		this.statsOf = statsOf;
		this.gamesWon = gamesWon;
		this.gamesPlayed = gamesPlayed;
		this.roundsPlayed = roundsPlayed;
		this.points = points;
		this.diceRolled = diceRolled;
		this.timePlayed = timePlayed;
	}

	/**
	 * Constructor, assigns reference to player
	 * 
	 * @param statsOf reference to the stats of this player
	 */
	public Stats(Player statsOf) {
		this.statsOf = statsOf;
	}

	/**
	 * Increase the number of games won
	 */
	public void increaseGamesWon() {
		this.gamesWon++;
	}

	/**
	 * Increase the number games played
	 */
	public void increaseGamesPlayed() {
		this.gamesPlayed++;
	}

	/**
	 * Increase the number games played
	 */
	public void increaseRoundsPlayed() {
		this.roundsPlayed++;
	}

	/**
	 * Increase the number of total points by n
	 * 
	 * @param n the amounts of points to be added
	 */
	public void increasePoints(int n) {
		this.points += n;
	}

	/**
	 * Increase the number of dice rolled
	 */
	public void increaseDiceRolled() {
		this.diceRolled++;
	}

	/**
	 * Increase the time played
	 * 
	 * @param time to be added
	 */
	public void increaseTimePlayed(int time) {
		this.timePlayed += time; // TODO time played increase
	}

	/**
	 * @return the diceRolled
	 */
	public int getDiceRolled() {
		return diceRolled;
	}

	/**
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @return the gamesWon
	 */
	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @return the roundsPlayed
	 */
	public int getRoundsPlayed() {
		return roundsPlayed;
	}

	/**
	 * @return the statsOf
	 */
	public Player getStatsOf() {
		return statsOf;
	}

	/**
	 * @return the timePlayed
	 */
	public double getTimePlayed() {
		return timePlayed;
	}
}