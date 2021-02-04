package game;

/**
 * contains information about a specific field on a card. a field holds three
 * possible values and can be crossed or chosen (even with a specific value)
 * 
 * @author Kjell Treder
 *
 */

public class Field {

    /**
     * name of this field
     */
    private final String name;

    /**
     * contains the default value of this field. the default value is set as the
     * chosen value, when this field gets chosen
     */
    private int defaultValue;

    /**
     * contains the possible, current value for this field. should this card be
     * chosen this value is set as the chosen value. this is calculated by the card
     * for each turn
     */
    private int currentValue;

    /**
     * contains the chosen value for this card. this value can only change once,
     * because a field can only be chosen once. the value is == -1 when the card is
     * crossed and > 0 when the card is chosen
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
     * get the value of this card for calculations. this means a crossed card is
     * valued at zero points, just like an unchosen card
     * 
     * @return value of this card
     */
    public int getChosenValue() {
        // a value of -1 means the card is worth 0
        return chosenValue == -1 ? 0 : chosenValue;
    }

    /**
     * get the current value of this field
     * 
     * @return value of this card
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * sets the current value for this card with a new value. this is done by
     * calculation from the card
     * 
     * @param value value to be set
     */
    public void setValue(int value) {
        this.currentValue = value;
    }

    /**
     * sets the current value to the default value
     */
    public void setValue() {
        this.currentValue = defaultValue;
    }

    /**
     * choose this field, sets the chosen value to the current value when the card
     * is open and if the current value is not 0
     * 
     * @return if choosing was successful
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
     * choose this field by giving it a value. only possible when this field is open
     * 
     * @param value the value for this field
     */
    public boolean choose(int value) {
        boolean result = isOpen();
        if (result) { // only an open field can be chosen
            this.chosenValue = value;
        }
        return result;
    }

    /**
     * cross this field. only possible when this field is open
     * 
     * @return if crossing was successful
     */
    public boolean cross() {
        boolean result = isOpen();
        if (result) { // only an open field can be crossed
            this.chosenValue = -1;
        }
        return result;
    }

    /**
     * check if this field is open. an open field has a chosen value of zero
     * 
     * @return if this field is open and can be chosen
     */
    public boolean isOpen() {
        return chosenValue == 0;
    }

    /**
     * check if this field is crossed. a crossed field has a chosen value of -1
     * 
     * @return if this field is crossed
     */
    public boolean isCrossed() {
        return chosenValue == -1;
    }

    /**
     * check if this field is chosen. a chosen field has a value greater than zero
     * 
     * @return if this field is chosen
     */
    public boolean isChosen() {
        return chosenValue > 0;
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
