package game;

import java.util.Random;

/**
 * contains information about a specific die with a value. a die can be rolled,
 * toggled to disable rolling and has value from 1 to 6 assigned to it with each
 * roll
 * 
 * @author Kjell Treder
 *
 */

public class Die {

    /**
     * true, if the die is rollable, otherwise false. if this value is false its
     * value will not change with a roll
     */
    private boolean isRollable = true;

    /**
     * value of the die
     */
    private int value;

    /**
     * random object for dice randomness
     */
    private static final Random rng = new Random();

    /**
     * roll the die. generates a random value for this die between 1 and 6, if this
     * die is rollable
     * 
     * @return true when rolled
     */
    public boolean roll() {
        if (isRollable) {
            value = 1 + rng.nextInt(6);
        }
        return isRollable;
    }

    /**
     * toggle the ability to roll this die
     */
    public void toggle() {
        isRollable = !isRollable;
    }

    /**
     * get the value of this die
     * 
     * @return value of the die
     */
    public int getValue() {
        return value;
    }

    /**
     * check if the die is rollable
     * 
     * @return true if this die is rollable, otherwise false
     */
    public boolean isRollable() {
        return isRollable;
    }
}