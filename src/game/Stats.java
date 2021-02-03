package game;

import java.util.GregorianCalendar;

/**
 * contains all statistical data for a player
 * 
 * @author Kjell Treder
 *
 */

public class Stats {

    private GregorianCalendar start; // time the player started playing

    // data which this stats saves
    private int gamesWon;
    private int gamesPlayed;
    private int roundsPlayed;
    private int points;
    private int diceRolled;
    private int timePlayed;

    /**
     * Constructor, assigns values
     * 
     * @param gamesWon     count of how many games have been won
     * @param gamesPlayed  count of how many games have been played
     * @param roundsPlayed count of how many rounds have been played
     * @param points       count of how many points have been acquired
     * @param diceRolled   count of how many dice have been rolled
     * @param timePlayed   seconds of time played
     */
    public Stats(int gamesWon, int gamesPlayed, int roundsPlayed, int points, int diceRolled, int timePlayed) {
        this.gamesWon = gamesWon;
        this.gamesPlayed = gamesPlayed;
        this.roundsPlayed = roundsPlayed;
        this.points = points;
        this.diceRolled = diceRolled;
        this.timePlayed = timePlayed;
    }

    /**
     * empty constructor
     */
    public Stats() {
        // all stats set to zero
    }

    /**
     * start playing
     */
    public void startPlaying() {
        start = new GregorianCalendar();
    }

    /**
     * stop playing
     */
    public void stopPlaying() {
        System.out.println("time saved");
        timePlayed += new GregorianCalendar().getTimeInMillis() - start.getTimeInMillis();
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
     * @return the timePlayed
     */
    public int getTimePlayed() {
        return timePlayed;
    }
}