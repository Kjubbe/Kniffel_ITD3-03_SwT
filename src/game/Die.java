package game;

import java.util.Random;

/**
 * This class holds information about a die, a die can be rollable or not
 * rollable, a die can be rolled
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public class Die {

	// data fields
	private final int id; // identifier for the die
	private boolean isRollable = true; // if the die is rollable
	private int value; // value of the die

	private static final Random rng = new Random();

	/**
	 * Constructor, gives an id to the die
	 * 
	 * @param id id of the die
	 */
	public Die(int id) {
		this.id = id;
	}

	/**
	 * Roll the die sets a number between one and six
	 */
	public void roll() {
		if (isRollable) {
			value = 1 + rng.nextInt(6);
		}
	}

	/**
	 * Toggle the rollable boolean of the die
	 */
	public void toggle() {
		isRollable = !isRollable;
	}

	/**
	 * Getter for the value
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Getter for the id
	 * 
	 * @return id of the die
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter for the status
	 * 
	 * @return rollable boolean of the die
	 */
	public boolean isRollable() {
		return isRollable;
	}
}