package game;

/**
 * This class holds information about a field, a field can be crossed or chosen
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public class Field {

	// data fields
	private final String name;
	private int points;
	private boolean isChosen;
	private boolean isCrossed;

	/**
	 * Constructor, defines a name for the field
	 * 
	 * @param name name of the field
	 */
	public Field(String name) {
		this.name = name;
	}

	/**
	 * Constructor, defines a name and points for the field
	 * 
	 * @param name   name of the field
	 * @param points points of the field
	 */
	public Field(String name, int points) {
		this.name = name;
		this.points = points;
	}

	/**
	 * Change the points for the field
	 * 
	 * @param points points
	 */
	public void changeValue(int points) {
		this.points = points;
	}

	/**
	 * Getter-method for points
	 * 
	 * @return points
	 */
	public int getValue() {
		return points;
	}

	/**
	 * Is the field crossed?
	 * 
	 * @return crossed
	 */
	public boolean isCrossed() {
		return isCrossed;
	}

	/**
	 * Is the field chosen?
	 * 
	 * @return chosen
	 */
	public boolean isChosen() {
		return isChosen;
	}

	/**
	 * Set the chosen value to true
	 * 
	 * @param b boolean to be set
	 */
	public void choose() {
		this.isChosen = true;
	}

	/**
	 * Set the crossed value to true
	 * 
	 * @param b boolean to be set
	 */
	public void cross(boolean b) {
		this.isCrossed = true;
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