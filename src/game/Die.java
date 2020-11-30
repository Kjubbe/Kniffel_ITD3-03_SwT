package game;

import java.util.Random;

/**
 * contains information about a specific die with a value. a die can be rolled
 * and toggled
 * 
 * @author Kjell Treder
 *
 */

public class Die {

	// data fields
	private boolean isRollable = true; // if the die is rollable
	private int value; // value of the die

	private static final Random rng = new Random();

	/**
	 * roll the die. generates a random value between 1 and 6
	 * 
	 * @return if successfull
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
	 * @return rollable boolean of the die
	 */
	public boolean isRollable() {
		return isRollable;
	}
}