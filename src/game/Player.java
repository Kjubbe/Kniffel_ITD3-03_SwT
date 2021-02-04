package game;

/**
 * contains information about the state of the player. the player participates
 * in the game, has stats and a card
 * 
 * @author Kjell Treder
 *
 */

public class Player {

    /**
     * name of the player
     */
    protected String name;

    /**
     * true if stats should be saved, otherwise false
     */
    protected boolean saveStats; // if the stats should be saved

    /**
     * reference to the stats object for this player
     */
    protected Stats myStats = new Stats();

    /**
     * reference to the card of this player
     */
    protected Card myCard = new Card();

    /**
     * amount of wins this player has for the current game
     */
    protected int wins;

    /**
     * constructor, sets the name
     * 
     * @param name name
     */
    public Player(String name) {
        this.name = name;
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
     * assign stats to this player
     * 
     * @param stats Stats to be assigned
     */
    public final void assignStats(Stats stats) {
        this.myStats = stats;
    }

    /**
     * increase number of wins
     */
    public void increaseWins() {
        this.wins++;
    }

    /**
     * assign a new card to this player
     */
    public final void assignCard() {
        this.myCard = new Card();
    }

    /**
     * getter for the name
     * 
     * @return name of this player
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the stats
     * 
     * @return stats of this player
     */
    public Stats getStats() {
        return myStats;
    }

    /**
     * getter for the card
     * 
     * @return card of this player
     */
    public Card getCard() {
        return myCard;
    }

    /**
     * getter for the points
     * 
     * @return total points for this player
     */
    public int getPoints() {
        return myCard.getTotal();
    }

    /**
     * getter for the amount of wins
     * 
     * @return win amount of this player
     */
    public int getWins() {
        return wins;
    }

    /**
     * check if player wants to save their stats
     * 
     * @return true if saving stats, otherwise false
     */
    public boolean isSavingStats() {
        return saveStats;
    }
}
