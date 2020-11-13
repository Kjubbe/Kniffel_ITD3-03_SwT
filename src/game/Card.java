package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static final int THREE_OF_A_KIND_INDEX = 6;
	private static final int FOUR_OF_A_KIND_INDEX = 7;
	private static final int FULL_HOUSE_INDEX = 8;
	private static final int SMALL_STRAIGHT_INDEX = 9;
	private static final int LARGE_STRAIGHT_INDEX = 10;
	private static final int YAHTZEE_INDEX = 11;
	private static final int CHANCE_INDEX = 12;

	// Fields on the card
	private final Field[] allFields = { new Field("Nur Einser Zählen"), new Field("Nur Zweier Zählen"),
			new Field("Nur Dreier Zählen"), new Field("Nur Vierer Zählen"), new Field("Nur Fünfer Zählen"),
			new Field("Nur Sechser Zählen"), new Field("Dreier Pasch"), new Field("Vierer Pasch"),
			new Field("Full House", 25), new Field("Kleine Straße", 30), new Field("Große Straße", 40),
			new Field("Kniffel", 50), new Field("Chance") };

	/**
	 * Constructor, assigns an owner to the card.
	 * 
	 * @param player Player, who is the owner of this card.
	 */
	public Card(Player player) {
		this.owner = player;
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
		int result = 0;
		for (int i = 0; i <= PART1_END_INDEX; i++) {
			result += allFields[i].getValue();
		}
		if (result >= BONUS_REQ) {
			result += BONUS;
		}
		return result;
	}

	/**
	 * Calculate and return the total points of the card
	 * 
	 * @return total points
	 */
	public int getPart2() {
		int result = 0;
		for (int i = PART1_END_INDEX + 1; i < allFields.length; i++) {
			result += allFields[i].getValue();
		}
		return result;
	}

	/**
	 * calculate the points for the fields
	 * 
	 * @param num value of the five die
	 */
	public void calculatePoints(Integer[] num) {
		bubbleSort(num);

		int total = 0;
		for (int n : num) {
			total += n;
		}

		/**
		 * counts how many pairs of adjacent numbers exist
		 */
		int pairs = 0;

		/**
		 * counts how many adjacent pairs of the same numbers exist
		 */
		int sameAdjacentPairs = 0;

		/**
		 * counts how many adjacent numbers are increasing by one
		 */
		int increase = 0;

		/**
		 * stores the number with an important property
		 */
		int specialNumber = 0;

		/**
		 * remembers if a triple exists
		 */
		boolean triple = false;

		/**
		 * remembers if a quad exists
		 */
		boolean quad = false;
		for (int i = 0; i < num.length - 1; i++) {
			// Test if the adjacent numbers are the same
			if (num[i] == num[i + 1]) {
				sameAdjacentPairs++; // increase amount of same adjacent pairs
				pairs++; // increase amount of pairs
			} else { // if the values are not the same, reset the same adjacent pairs, since the next
						// number is a different one
				sameAdjacentPairs = 0;
			}

			// Test if the adjacent numbers are increasing
			if (num[i] == num[i + 1] + 1) {
				increase++;
			}

			// two adjacent pairs are equal to three same numbers
			// triple found
			if (sameAdjacentPairs == 2 && !triple) { // its a triple // TODO check if boolean triple check is needed
				specialNumber = num[i]; // store the special number for the triple
				triple = true;
			}
			// three adjacent pairs are equal to three same numbers
			// triple found
			if (sameAdjacentPairs == 3 && !quad) { // its also a quad // TODO check if boolean quad check is needed
				quad = true;
			}
		}
		int sumOfSame = 0; // calculate sum of dice with value
		for (int i = 0; i <= 4; i++) {
			if (num[i] == specialNumber)
				sumOfSame += num[i];
		}

		Field currentField;

		/**
		 * part 1: only one field in part 1 can be chosen each turn, because three dice
		 * are needed and there are only five dice three dice also = Three Of A Kind
		 */
		if (triple) {
			allFields[specialNumber + 1].setValue(sumOfSame);
			allFields[THREE_OF_A_KIND_INDEX].setValue(total);

			/**
			 * four of a kind,
			 * if four dice have the same value
			 */
			if (quad) {
				allFields[FOUR_OF_A_KIND_INDEX].setValue(total);
			}
		}

		/**
		 * full house full house needs to have exactly three pairs
		 */
		if (pairs == 3 && sameAdjacentPairs <= 2 && sameAdjacentPairs >= 1) { // TODO check if check is needed
			allFields[FULL_HOUSE_INDEX].setValue();
		}

		/**
		 * small straight, for the small straight the increasing value needs to be 3 or
		 * greater than 3
		 */
		if (increase >= 3) {
			allFields[SMALL_STRAIGHT_INDEX].setValue();

			/**
			 * large straight, for the large straight the increasing value needs to be 4
			 */
			if (increase == 4) {
				allFields[LARGE_STRAIGHT_INDEX].setValue();
			}
		}

		/**
		 * yahtzee, if four pairs have been found
		 */
		if (pairs == 4) {
			allFields[YAHTZEE_INDEX].setValue();
		}

		/**
		 * chance
		 */
		allFields[CHANCE_INDEX].setValue(total);

	}

	/**
	 * cross a field
	 * 
	 * @param field the field to be crossed
	 * @return if successful
	 */
	public boolean crossField(Field field) {
		return field.cross();
	}

	/**
	 * choose a field
	 * 
	 * @param field the field to be chosen
	 * @return if successful
	 */
	public boolean chooseField(Field field) {
		return field.choose();
	}

	/**
	 * choose a field and set its value
	 * 
	 * @param field the field to be chosen
	 * @param value the new value of the field
	 */
	public void chooseField(Field field, int value) {
		field.choose(value);
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