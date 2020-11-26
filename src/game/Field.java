package game;

/**
 * This class holds information about a field, a field can be crossed or chosen
 * 
 * @author Kjell Treder
 *
 */

public class Field {

	// data fields
	private final String name;

	/**
	 * contains the default value of this card most cards do not have a default
	 * value
	 */
	private int defaultValue = 0;

	/**
	 * contains the possible, current value for this card this is calculated by the
	 * card
	 */
	private int currentValue = 0;

	/**
	 * contains the chosen value for this card. this value can only change once it
	 * is -1 if the card is crossed
	 */
	private int chosenValue = 0;

	/**
	 * Constructor, defines a name for the field
	 * 
	 * @param name name of the field
	 */
	public Field(String name) {
		this.name = name;
	}

	/**
	 * Constructor, defines a name and a default value for the field
	 * 
	 * @param name         name of the field
	 * @param defaultValue value of the field
	 */
	public Field(String name, int defaultValue) {
		this.name = name;
		this.defaultValue = defaultValue;
	}

	/**
	 * get the actual value of this card
	 * 
	 * @return value of this card
	 */
	public int getValue() {
		// a value of -1 means the card is worth 0
		return chosenValue == -1 ? 0 : chosenValue;
	}

	/**
	 * set the current value for this card
	 * 
	 * @param value value to be set
	 */
	public void setValue(int value) {
		this.currentValue = value;
	}

	/**
	 * set the current value to the default value
	 */
	public void setValue() {
		this.currentValue = defaultValue;
	}

	/**
	 * choose this field, sets the chosen value to the current value if the card is
	 * not chosen or crossed and if the current value is not 0
	 * 
	 * @return if successful
	 */
	public boolean choose() {
		boolean result = isOpen() && currentValue != 0;
		if (result) {
			this.chosenValue = currentValue;
		}
		return result;
	}

	/**
	 * choose this field by giving it a value
	 * 
	 * @param value the value for this field
	 */
	public void choose(int value) {
		this.chosenValue = value;
	}

	/**
	 * cross this field
	 * 
	 * @return if successful
	 */
	public boolean cross() {
		if (isOpen()) {
			this.chosenValue = -1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check if this field is open
	 * 
	 * @return if open
	 */
	public boolean isOpen() {
		return chosenValue == 0;
	}

	/**
	 * Getter-method for the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	// TODO calculate the points
}