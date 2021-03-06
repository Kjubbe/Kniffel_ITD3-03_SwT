package game;

import java.util.Arrays;

/**
 * contains information about a card of a player. a card consists of multiple
 * fields. the player can choose or cross fields. this class manages all
 * calculations with points for the fields on the card
 * 
 * @author Kjell Treder
 *
 */

public class Card {

    /**
     * the amount of bonus points added
     */
    public static final int BONUS = 35;

    /**
     * the required amount of points needed in part 1 to get the bonus points
     */
    private static final int BONUS_REQ = 63;

    /**
     * index of the last field on the allFields array from the first part
     */
    private static final int PART1_END_INDEX = 5;

    // indices of all the fields on the card
    private static final int THREE_OF_A_KIND_INDEX = 6;
    private static final int FOUR_OF_A_KIND_INDEX = 7;
    private static final int FULL_HOUSE_INDEX = 8;
    private static final int SMALL_STRAIGHT_INDEX = 9;
    private static final int LARGE_STRAIGHT_INDEX = 10;
    private static final int YAHTZEE_INDEX = 11;
    private static final int CHANCE_INDEX = 12;

    /**
     * contains all names for the fields. used for displaying and for the actual
     * fields
     */
    public static final String[] FIELD_NAMES = { "Nur Einser Zählen", "Nur Zweier Zählen", "Nur Dreier Zählen",
            "Nur Vierer Zählen", "Nur Fünfer Zählen", "Nur Sechser Zählen", "Dreier Pasch", "Vierer Pasch",
            "Full House", "Kleine Straße", "Große Straße", "Kniffel", "Chance" };

    /**
     * array with all fields on this card. each field gets constructed with their
     * name and an optional default value
     */
    public final Field[] allFields = { new Field(FIELD_NAMES[0]), new Field(FIELD_NAMES[1]), new Field(FIELD_NAMES[2]),
            new Field(FIELD_NAMES[3]), new Field(FIELD_NAMES[4]), new Field(FIELD_NAMES[5]), new Field(FIELD_NAMES[6]),
            new Field(FIELD_NAMES[7]), new Field(FIELD_NAMES[8], 25), new Field(FIELD_NAMES[9], 30),
            new Field(FIELD_NAMES[10], 40), new Field(FIELD_NAMES[11], 50), new Field(FIELD_NAMES[12]) };

    /**
     * get the total points of the card
     * 
     * @return total points with bonus if applicable
     */
    public int getTotal() {
        return getPart1(true) + getPart2();
    }

    /**
     * get the sum of the points of part 1
     * 
     * @param withBonus if the calculation should include the bonus if applicable
     * @return part 1 total
     */
    public int getPart1(boolean withBonus) {
        int result = 0;
        for (int i = 0; i <= PART1_END_INDEX; i++) { // iterate over all fields of part 1
            result += allFields[i].getChosenValue();
        }
        if (withBonus && result >= BONUS_REQ) { // add the bonus if applicable
            result += BONUS;
        }
        return result;
    }

    /**
     * get the sum of the points of part 2
     * 
     * @return part 2 total
     */
    public int getPart2() {
        int result = 0;
        for (int i = PART1_END_INDEX + 1; i < allFields.length; i++) { // iterate over all fields of part 2
            result += allFields[i].getChosenValue();
        }
        return result;
    }

    /**
     * calculate the the available points for each field from the five dice values
     * 
     * @param num values of the five dice
     */
    public void calculatePoints(int[] num) {
        // reset all fields
        setToZero();

        // first, sort the values
        num = bubbleSort(num);

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

        // check every value
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
            } else {
                if (increase < 3 && num[i] != num[i + 1]) {
                    increase = 0;
                }
            }

            // two adjacent pairs are equal to three same numbers
            // triple found
            if (sameAdjacentPairs == 2 && !triple) { // its a triple
                specialNumber = num[i]; // store the special number for the triple
                triple = true;
            }
            // three adjacent pairs are equal to three same numbers
            // triple found
            if (sameAdjacentPairs == 3 && !quad) { // its also a quad
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
        if (pairs == 3 && sameAdjacentPairs <= 2 && sameAdjacentPairs >= 1) {
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
     * cross a field by index
     * 
     * @param index the index of the field to be crossed
     * @return if the field was crossed
     */
    public boolean crossField(int index) {
        Field field = allFields[index];
        boolean result = field.cross(); // try crossing the field
        if (result) { // reset, when field is crossed
            setToZero();
        }
        return result;
    }

    /**
     * choose a field by index
     * 
     * @param index the index of the field to be chosen
     * @return if the field was chosen
     */
    public boolean chooseField(int index) {
        Field field = allFields[index];
        boolean result = field.choose(); // try choosing the field
        if (result) { // reset, when field is chosen
            setToZero();
        }
        return result;
    }

    /**
     * choose a field by index and set its value. this is needed when playing
     * without autocalc
     * 
     * @param index the index of the field to be crossed
     * @param value the new value of the field
     * @return if the field was chosen
     */
    public boolean chooseField(int index, int value) {
        Field field = allFields[index];
        return field.choose(value); // choose the field with the value
    }

    /**
     * bubble-sorting algorithm for sorting the dice values
     * 
     * @param num value of the five dice
     * @return num, but sorted
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
