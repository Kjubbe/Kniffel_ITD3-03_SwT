package game;

import java.util.GregorianCalendar;

/**
 * contains all statistical data for a player
 * 
 * @author Kjell Treder
 *
 */

public class Stats {

    /**
     * starting time, is set when the game begins
     */
    private GregorianCalendar start;

    /**
     * amount of games won over multiple games
     */
    private int gamesWon;

    /**
     * amount of games played over multiple games
     */
    private int gamesPlayed;

    /**
     * amount of rounds played over multiple games
     */
    private int roundsPlayed;

    /**
     * amount of points gathered over multiple games
     */
    private int points;

    /**
     * amount of dice rolled over multiple games
     */
    private int diceRolled;

    /**
     * amount of time played over multiple games
     */
    private int timePlayed;

    /**
     * constructor, assigns all values
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
     * start playing, creates a new timestamp
     */
    public void startPlaying() {
        start = new GregorianCalendar();
    }

    /**
     * stop playing
     */
    public void stopPlaying() {
        // create a new timestamp and add the difference from finish and start to the
        // time played
        timePlayed += new GregorianCalendar().getTimeInMillis() - start.getTimeInMillis();
    }

    /**
     * increase the number of games won
     */
    public void increaseGamesWon() {
        this.gamesWon++;
    }

    /**
     * increase the number of games played
     */
    public void increaseGamesPlayed() {
        this.gamesPlayed++;
    }

    /**
     * increase the number of rounds played
     */
    public void increaseRoundsPlayed() {
        this.roundsPlayed++;
    }

    /**
     * increase the number of total points by n
     * 
     * @param n the amounts of points to be added
     */
    public void increasePoints(int n) {
        this.points += n;
    }

    /**
     * increase the number of dice rolled
     */
    public void increaseDiceRolled() {
        this.diceRolled++;
    }

    /**
     * getter for diceRolled
     * 
     * @return the amount of dice rolled
     */
    public int getDiceRolled() {
        return diceRolled;
    }

    /**
     * getter for gamesPlayed
     * 
     * @return the amount of games played
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * getter for gamesWon
     * 
     * @return the amount of games won
     */
    public int getGamesWon() {
        return gamesWon;
    }

    /**
     * getter for the points
     * 
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * getter for roundsPlayed
     * 
     * @return the amount of rounds played
     */
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    /**
     * getter for timePlayed
     * 
     * @return the time played
     */
    public int getTimePlayed() {
        return timePlayed;
    }
}