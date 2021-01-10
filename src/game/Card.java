package game;

import java.util.Arrays;

/**
 * contains information about a card of a player. the player can choose or cross
 * fields. this class also manages all calculations with points for all existing
 * fields
 * 
 * @author Kjell Treder
 *
 */

public class Card {

	private Player owner; // card owner
	private static final int BONUS = 35; // the amount of bonus points
	private static final int BONUS_REQ = 63; // the required amount of points in part 1 to get bonus points
	private static final int PART1_END_INDEX = 5;

	// indices of the fields on the card
	private static final int THREE_OF_A_KIND_INDEX = 6;
	private static final int FOUR_OF_A_KIND_INDEX = 7;
	private static final int FULL_HOUSE_INDEX = 8;
	private static final int SMALL_STRAIGHT_INDEX = 9;
	private static final int LARGE_STRAIGHT_INDEX = 10;
	private static final int YAHTZEE_INDEX = 11;
	private static final int CHANCE_INDEX = 12;

	// names for the fields
	public static final String[] FIELD_NAMES = { "Nur Einser Zählen", "Nur Zweier Zählen", "Nur Dreier Zählen",
			"Nur Vierer Zählen", "Nur Fünfer Zählen", "Nur Sechser Zählen", "Dreier Pasch", "Vierer Pasch",
			"Full House", "Kleine Straße", "Große Straße", "Kniffel", "Chance" };

	// array with all the fields on this card
	public final Field[] allFields = new Field[FIELD_NAMES.length];

	/**
	 * constructor, assigns a player to this card
	 * 
	 * @param player the owner of this card
	 */
	public Card(Player player) {
		this.owner = player;

		// add all fields to the array
		for (int i = 0; i < FIELD_NAMES.length; i++) {
			allFields[i] = new Field(FIELD_NAMES[i]);
		}
            allFields[FULL_HOUSE_INDEX].defaultValue = 25;
            allFields[SMALL_STRAIGHT_INDEX].defaultValue = 30;
            allFields[LARGE_STRAIGHT_INDEX].defaultValue = 40;
            allFields[YAHTZEE_INDEX].defaultValue = 50;
	}

	/**
	 * get the card owner
	 * 
	 * @return player object, who owns this card
	 */
	public Player getCardOwner() {
		return owner;
	}

	/**
	 * calculate and return the total points of the card
	 * 
	 * @return total points
	 */
	public int getTotal() {
		return getPart1(true) + getPart2();
	}

	/**
	 * calculate and return the points of part 1
	 * 
	 * @param withBonus if the point calculation should include the bonus if
	 *                  applicable
	 * @return points of part 1
	 */
	public int getPart1(boolean withBonus) {
		int result = 0;
		for (int i = 0; i <= PART1_END_INDEX; i++) {
			result += allFields[i].getValue();
		}
		if (withBonus && result >= BONUS_REQ) {
			result += BONUS;
		}
		return result;
	}

	/**
	 * calculate and return the total points of part 2
	 * 
	 * @return points of part 2
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
	 * @param num values of the five dice
	 */
	public void calculatePoints(int[] num) {
		// first, sort the values
		num = bubbleSort(num);
                
                System.out.println(Arrays.toString(num));

		// calculate the total
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
			// test if the adjacent numbers are the same
			if (num[i] == num[i + 1]) {
				sameAdjacentPairs++; // increase amount of same adjacent pairs
				pairs++; // increase amount of pairs
			} else { // if the values are not the same, reset the same adjacent pairs, since the next
						// number is a different one
				sameAdjacentPairs = 0;
			}

			// test if the adjacent numbers are increasing
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

		/**
		 * part 1: only one field in part 1 can be chosen each turn, because three dice
		 * are needed and there are only five dice three dice also = Three Of A Kind
		 */
		if (triple) {
			allFields[specialNumber - 1].setValue(sumOfSame);
			allFields[THREE_OF_A_KIND_INDEX].setValue(total);

			/**
			 * four of a kind, if four dice have the same value
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
	 * @param index the index of the field to be crossed
	 * @return if successful
	 */
	public boolean crossField(int index) {
		Field field = allFields[index];
		boolean result = field.cross();
		if (result)
			setToZero();
		return result;
	}

	/**
	 * choose a field
	 * 
	 * @param index the index of the field to be crossed
	 * @return if successful
	 */
	public boolean chooseField(int index) {
		Field field = allFields[index];
		boolean result = field.choose();
		if (result)
			setToZero();
		return result;
	}

	/**
	 * choose a field and set its value. this is useful when playing without
	 * autofill
	 * 
	 * @param index the index of the field to be crossed
	 * @param value the new value of the field
	 */
	public void chooseField(int index, int value) {
		Field field = allFields[index];
		field.choose(value);
	}

	/**
	 * bubble-sorting algorithm for sorting the dice values
	 * 
	 * @param num value of the five dice
	 */
	private static int[] bubbleSort(int[] num) {
		boolean unsorted = true;
		while (unsorted) {
			unsorted = false;
			for (int i = 0; i < num.length - 1; i++) {
				if ((num[i] < num[i + 1])) {
					int dummy = num[i];
					num[i] = num[i + 1];
					num[i + 1] = dummy;
					unsorted = true;
				}
			}
		}
		return num;
	}

	/**
	 * set all field values to zero
	 */
	public void setToZero() {
		for (Field f : allFields) {
			f.setValue(0);
		}
	}
}
