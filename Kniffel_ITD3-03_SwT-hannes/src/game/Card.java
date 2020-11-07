package game;

import java.util.List;

/**
 * This class holds information about the card of a player, it contains all 13
 * fields
 * 
 * @author Kjell Treder @Kjubbe
 *
 */

public class Card {

	// Data fields

	private Player owner; // Card Owner
	private static final int BONUS = 35; // Bonus points for reaching 63 points on the first card
	private static final int BONUS_REQ = 63;
	private static final int PART1_END_INDEX = 5;
	private int openFields = 13; // Number of Fields to be chosen or crossed

	// Fields on the card
	protected final Field[] fields = { new Field("Nur Einser Zählen"), new Field("Nur Zweier Zählen"),
			new Field("Nur Dreier Zählen"), new Field("Nur Vierer Zählen"), new Field("Nur Fünfer Zählen"),
			new Field("Nur Sechser Zählen"), new Field("Dreier Pasch"), new Field("Vierer Pasch"),
			new Field("Full House", 25), new Field("Kleine Straße", 30), new Field("Große Straße", 40),
			new Field("Kniffel", 50), new Field("Chance") };

	/**
	 * Constructor.
	 */
	public Card() {
	}

	/**
	 * Constructor, assigns an owner to the card.
	 * 
	 * @param player Player, who is the owner of this card.
	 */
	public Card(Player player) {
		this.owner = player;
	}

	/**
	 * Get the number of open fields for this card
	 * 
	 * @return number of open fields
	 */
	public int getOpenFields() {
		return openFields;
	}

	/**
	 * decrease the number of open fields
	 */
	public void decreaseOpenFields() {
		openFields--;
	}

	/**
	 * Getter for owner of the card
	 * 
	 * @return Player, who owns the card
	 */
	public Player getCardOwner() {
		return owner;
	}

	/**
	 * Calculate and return the total points of the card
	 * 
	 * @return total points
	 */
	public int getTotal() {
		return getPart1() + getPart2();
	}

	/**
	 * Calculate and return the total points of the card
	 * 
	 * @return total points
	 */
	public int getPart1() {
		int part1 = 0;
		for (int i = 0; i <= PART1_END_INDEX; i++) {
			if (fields[i].isChosen()) {
				part1 += fields[i].getValue();
			}
		}
		if (part1 >= BONUS_REQ) {
			part1 += BONUS;
		}
		return part1;
	}

	/**
	 * Calculate and return the total points of the card
	 * 
	 * @return total points
	 */
	public int getPart2() {
		int part2 = 0;
		for (int i = 6; i < fields.length; i++) {
			if (fields[i].isChosen()) {
				part2 += fields[i].getValue();
			}
		}
		return part2;
	}

	/**
	 * Find the available fields after a finishing a turn and return them in a list
	 * 
	 * @param num value of the five die
	 * @return list of possible fields to be chosen
	 */
	public List<Field> availableFields(Integer[] num) {
		// TODO go through all fields and check if they can be chosen
		return null;
	}

	/**
	 * Find all crossable fields after a finishing a turn and return them in a list
	 * 
	 * @return list of possible fields to be chosen
	 */
	public List<Field> crossableFields() {
		// TODO return all fields
		return null;
	}

	/**
	 * bubble-sorting algorithm for sorting the dice
	 * 
	 * @param num value of the five die
	 */
	private void bubbleSort(Integer[] num) {
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < num.length - 1; i++) {
				if (!(num[i] >= num[i + 1])) {
					int dummy = num[i];
					num[i] = num[i + 1];
					num[i + 1] = dummy;
					unsorted = true;
				}
			}
		}
	}
}