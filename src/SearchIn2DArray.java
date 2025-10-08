import java.util.Arrays;

/**
 * A class to demonstrate searching for an element in a 2D array.
 */
public class SearchIn2DArray {

    /**
     * The main method serves as the entry point and runs the search demonstrations.
     */
    public static void main(String[] args) {
        // Define a 2D integer array (a matrix)
        // Think of this as a grid with rows and columns.
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };

        // --- Demo 1: Find a number that exists ---
        int targetExists = 37;
        int[] result1 = linearSearch2D(matrix, targetExists);

        System.out.println("Searching for target: " + targetExists);
        if (result1[0] != -1) {
            System.out.println("Target found at -> Row: " + result1[0] + ", Column: " + result1[1]);
            System.out.println("Result array: " + Arrays.toString(result1));
        } else {
            System.out.println("Target not found in the matrix.");
        }

        System.out.println("\n------------------------------------------\n");

        // --- Demo 2: Find a number that does NOT exist ---
        int targetMissing = 99;
        int[] result2 = linearSearch2D(matrix, targetMissing);
        
        System.out.println("Searching for target: " + targetMissing);
        if (result2[0] != -1) {
            System.out.println("Target found at -> Row: " + result2[0] + ", Column: " + result2[1]);
        } else {
            System.out.println("Target not found in the matrix.");
            System.out.println("Result array: " + Arrays.toString(result2));
        }
    }

    /**
     * Performs a linear search for a target value in a 2D integer array.
     * It iterates through every element until the target is found.
     *
     * @param matrix The 2D array to search within.
     * @param target The integer value to search for.
     * @return An integer array containing the {row, column} of the target if found,
     * otherwise returns {-1, -1}.
     */
    public static int[] linearSearch2D(int[][] matrix, int target) {
        // Handle the edge case where the matrix might be null or empty.
        if (matrix == null || matrix.length == 0) {
            return new int[]{-1, -1};
        }

        // The outer loop iterates through each row of the matrix.
        for (int row = 0; row < matrix.length; row++) {
            // The inner loop iterates through each column in the current row.
            // We use matrix[row].length because rows can have different lengths.
            for (int col = 0; col < matrix[row].length; col++) {
                // Check if the element at the current [row][col] is the target.
                if (matrix[row][col] == target) {
                    // If found, return the coordinates immediately.
                    return new int[]{row, col};
                }
            }
        }

        // If the loops complete without finding the target, it's not in the array.
        return new int[]{-1, -1};
    }
}
