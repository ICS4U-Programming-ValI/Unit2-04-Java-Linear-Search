import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the package for LinearSearch.java
 *
 * The LinearSearch program makes 5 arrays.
 * For each array:
 * it shows the sorted array of 10 ints in numerical order,
 * and asks the user for a number to search for.
 * It then searches for the number in the array 
 * and displays the index it is in
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @version 1.0
 * @since 2025-03-18
 */

public final class LinearSearch {

    /**
     * The size of the array to be populated. */
    private static final int ARRAYSIZE = 10;

    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private LinearSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args unused.
     */
    public static void main(final String[] args) {
        Random rand = new Random();
        int arrayOfInts[] = new int[ARRAYSIZE];
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        String search;
        int counter;
        do {
            // populate array with random numbers
            for (int i = 0; i < ARRAYSIZE; i++) {
                arrayOfInts[i] = rand.nextInt(100);
            }

            // sort array
            Arrays.sort(arrayOfInts);
            // prints sorted array
            System.out.print("Sorted array: ");
            System.out.println(Arrays.toString(arrayOfInts));
            System.out.print("Enter a number to search for, ");
            System.out.println("or q to quit: ");
            search = scanner.nextLine().toLowerCase();

            if (search.equals("q")) {
                break;
            } else {
                try {
                    int searchInt = Integer.parseInt(search);
                    for (counter = 0; counter < ARRAYSIZE; counter++) {
                        if (arrayOfInts[counter] == searchInt) {
                            found = true;
                            break;
                        }
                    }
                    if (found == false) {
                        System.out.println("The number " + searchInt + " is not in the array.");
                    } else {
                        System.out.println("The number " + searchInt + " is at index " + counter + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a number.");
                }
            }
        } while (!search.equals("q"));
        scanner.close();
    }
}
