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

	// TODO change to cardOwner?
	private Player cardOf; // Card Owner
	private final int bonus = 35; // Bonus points for reaching 63 points on the first card
	private int openFields = 13; // Number of Fields to be chosen or crossed // TODO maybe work with the array?

	// Fields on the card
	// TODO convert to a list to remove elements and work with that
	private final Field[] fields = new Field[] { new Field("Nur Einser Zählen"), new Field("Nur Zweier Zählen"),
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
		this.cardOf = player;
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
		return cardOf;
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
		for (int i = 0; i <= 5; i++) { // TODO remove hard coding the 5
			if (fields[i].isChosen()) {
				part1 += fields[i].getValue();
			}
		}
		if (part1 >= 63) { // TODO make 63 a constant
			part1 += bonus;
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
		for (int i = 6; i <= 12; i++) { // TODO dont hard code the 12 and 6 here, use constants
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