package comp1110.lectures.C01;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Generates a string representing a randomly-generated Boggle dice roll.
 */
public class Boggle {
    static String[] dice = {"AJBBOO", "AFFPSK", "ANEAGE", "APSHCO", "QNUMHI", "ZNHRLN", "TDSTYI", "TTWOOA", "TLRYET", "TUMIOC", "EDVLRY", "EDRLXI", "EEGNHW", "EIOTSS", "ERHTWV", "EENUSI"};

    static final int ROW_LENGTH = 4;

    /** The set of neighbours for each die */
    static List<HashSet<Integer>> neighbours = new ArrayList<HashSet<Integer>>(dice.length);

    /**
     * This code generates the set of neighbours for each die.
     * This will be used in the search to know which dice can be visited
     * from a given die.
     *
     * We assume that the dice are numbered:
     *
     *  0   1  2  3
     *  4   5  6  7
     *  8   9 10 11
     *  12 13 14 15
     *
     *  So for example the neighbours of die 0 are 1, 4, and 5;
     *  the neighbours of die 5 are 0, 1, 2, 4, 6, 8, 9, and 10; and
     *  the neighbours of die 11 are 6, 7, 10, 14, and 15.
     */
    static {
        /*
         * This array describes the difference between the index of a die and
         * the index of each of its possible neighbours.
         */
        int[] distance = {-1, -ROW_LENGTH - 1, -ROW_LENGTH, -ROW_LENGTH + 1, +1, +ROW_LENGTH + 1, +ROW_LENGTH, +ROW_LENGTH - 1};
        for (int i = 0; i < dice.length; i++) {
            HashSet<Integer> myNeighbours = new HashSet<>();
            /*
             * For each distance, determine whether the resulting die is
             * really a neighbour, and if so, add it
             */
            for (int d : distance) {
                int neighbourId = i + d;
                int ncol = neighbourId % ROW_LENGTH; // neighbour column
                int icol = i % ROW_LENGTH; // my column
                if (neighbourId >= 0 && neighbourId <= 15 && Math.abs(ncol - icol) <= 1) {
                    myNeighbours.add(neighbourId);
                }
            }
            neighbours.add(myNeighbours);
        }
    }

    /**
     * Solve a boggle game.
     * @param boggleCharacters a Boggle board, representing the layout of the 16 dice
     * @param dictionary a list of English words
     * @return a list of all the words in the dictionary that can be made
     *         using the given boggleCharacters
     */
    public static List<String> solve(char[] boggleCharacters, List<String> dictionary) {
        List<String> results = new ArrayList<>();

        return results;
    }

    @Test
    public void testEnglishWords() {
        char[] boggleCharacters = shake();
        List<String> dictionary = processDictionary("assets/dictionary.txt");
        List<String> words = solve(boggleCharacters, dictionary);
        for (String word : words) {
            assertTrue(dictionary.contains(word));
        }
    }

    @Test
    public void testWordLength() {
        char[] boggleCharacters = shake();
        List<String> dictionary = processDictionary("assets/dictionary.txt");
        List<String> words = solve(boggleCharacters, dictionary);
        for (String word : words) {
            assertTrue("Word is too short: " + word, word.length() >= 3);
            assertTrue("Word is too long: " + word, word.length() <= 16);
        }
    }

    /**
     *  0   1  2  3
     *  4   5  6  7
     *  8   9 10 11
     *  12 13 14 15
     */
    @Test
    public void testNeighbours() {
        int[] neighboursOfZero = {1, 4, 5};
        HashSet<Integer> computedZero = neighbours.get(0);
        assertTrue(computedZero.size() == 3);
        for (Integer n : neighboursOfZero) {
            assertTrue(computedZero.contains(n));
        }
    }

    /**
     * Read in a dictionary from a file name, and create a set of words that
     * will be used by the Boggle solver to decide if a string is a valid word.
     *
     * The simple approach is just to read all the words in a dictionary into
     * a set of Strings.
     *
     * TODO optimizations
     *
     * @param filename the name of the file containing the dictionary
     * @return a list of words to be used by the Boggle solver
     */
    static List<String> processDictionary(String filename) {
        List<String> words = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNext()) {
                words.add(s.next().toUpperCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }

    /**
     * Create a Boggle board by 'shaking' the 16 dice.
     * This function randomizes the order of the dice, and also rolls each die,
     * choosing an upward face ranomly.
     *
     * @return a randomized array of 16 characters,
     *         each chosen from one of the boggle dice
     */
    private static char[] shake() {
        char[] boggleDice = new char[16];
        Random rand = new Random();
        boolean[] alreadyUsed = new boolean[dice.length];
        for (int i = 0; i < 16; i++) {
            int dieNumber = rand.nextInt(16);
            while (alreadyUsed[dieNumber]) {
                dieNumber = rand.nextInt(16); // keep trying random numbers
                //dieNumber = (dieNumber + 1) % dice.length; // check the next die
            }

            int face = rand.nextInt(6);
            char faceChar = dice[dieNumber].charAt(face);
            boggleDice[i] = faceChar;
            System.out.print(faceChar);
            if (i % ROW_LENGTH == ROW_LENGTH - 1) System.out.print('\n');
            alreadyUsed[dieNumber] = true;
        }
        return boggleDice;
    }

    public static void main(String[] args) {
        char[] boggleCharacters = shake();
        List<String> dictionary = processDictionary("assets/dictionary.txt");
        System.out.println("Found " + dictionary.size() + " words.");
        List<String> words = solve(boggleCharacters, dictionary);
        System.out.println("Found " + words.size() + " Boggle words.");
    }
}
