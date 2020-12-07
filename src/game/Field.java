package game;

/**
 * contains information about a specific field on a card. a field holds three
 * values and can be crossed or chosen
 * 
 * @author Kjell Treder
 *
 */

public class Field {

	private final String name;

	/**
	 * contains the default value of this field. most fields do not have a default
	 * value
	 */
	public int defaultValue;

	/**
	 * contains the possible, current value for this field. this is calculated by
	 * the card for each turn
	 */
	private int currentValue;

	/**
	 * contains the chosen value for this card. this value can only change once. it
	 * is -1 if the card is crossed
	 */
	private int chosenValue;

	/**
	 * constructor, defines a name for the field
	 * 
	 * @param name name of the field
	 */
	public Field(String name) {
		this.name = name;
	}

	/**
	 * constructor, defines a name and a default value for the field
	 * 
	 * @param name         name of the field
	 * @param defaultValue value of the field
	 */
	public Field(String name, int defaultValue) {
		this.name = name;
		this.defaultValue = defaultValue;
	}

	/**
	 * get the actual value of this card for calculations
	 * 
	 * @return value of this card
	 */
	public int getValue() {
		// a value of -1 means the card is worth 0
		return chosenValue == -1 ? 0 : chosenValue;
	}

	/**
	 * get the current value
	 * 
	 * @return value of this card
	 */
	public int getCurrentValue() {
		return currentValue;
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
	 * choose this field, sets the chosen value to the current value when the card
	 * is not chosen or crossed and if the current value is not 0
	 * 
	 * @return if successful
	 */
	public boolean choose() {
		// there is no point in choosing a card which is worth 0 points. so it is not
		// possible
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
		boolean result = isOpen();
		if (result) {
			this.chosenValue = -1;
		}
		return result;
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
	 * check if this field is crossed
	 * 
	 * @return if crossed
	 */
	public boolean isCrossed() {
		return chosenValue == -1;
	}

	/**
	 * get the name of this card
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
}
