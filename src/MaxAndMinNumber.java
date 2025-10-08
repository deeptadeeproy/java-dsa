public class MaxAndMinNumber {

    /**
     * The main method to demonstrate all array functions.
     */
    public static void main(String[] args) {
        int[] numbers = {45, 12, 88, 6, 92, 24, 50, -3};
        System.out.println("Original Array: " + java.util.Arrays.toString(numbers));
        
        System.out.println("--- Finding Min/Max of Entire Array ---");
        System.out.println("Maximum number is: " + findMax(numbers));
        System.out.println("Minimum number is: " + findMin(numbers));

        System.out.println("\n--- Finding Min/Max in a Specific Range [2, 6] ---");
        int startIndex = 2;
        int endIndex = 6;
        // The sub-array is {88, 3, 97, 24, 50}
        
        int maxInRange = findMaxInRange(numbers, startIndex, endIndex);
        int minInRange = findMinInRange(numbers, startIndex, endIndex);
        
        System.out.printf("Maximum in range [%d, %d] is: %d\n", startIndex, endIndex, maxInRange); // Should be 97
        System.out.printf("Minimum in range [%d, %d] is: %d\n", startIndex, endIndex, minInRange); // Should be 3
    }

    // --- FUNCTIONS FOR THE ENTIRE ARRAY ---

    /**
     * Finds the maximum value in an integer array.
     * @param arr The array to search through.
     * @return The largest integer in the array.
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        return findMaxInRange(arr, 0, arr.length - 1); // Reuse the range function
    }

    /**
     * Finds the minimum value in an integer array.
     * @param arr The array to search through.
     * @return The smallest integer in the array.
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        return findMinInRange(arr, 0, arr.length - 1); // Reuse the range function
    }

    // --- NEW FUNCTIONS FOR A SPECIFIC RANGE ---

    /**
     * Finds the maximum value within a range of indices in an array.
     * @param arr The array to search through.
     * @param start The starting index of the range (inclusive).
     * @param end The ending index of the range (inclusive).
     * @return The largest integer in the specified range.
     */
    public static int findMaxInRange(int[] arr, int start, int end) {
        // --- Input Validation ---
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        if (start < 0 || end >= arr.length || start > end) {
            throw new IllegalArgumentException("Invalid range. Start must be less than end and within bounds.");
        }

        // Assume the first element in the range is the largest
        int max = arr[start];

        // Loop through the rest of the elements in the range
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Finds the minimum value within a range of indices in an array.
     * @param arr The array to search through.
     * @param start The starting index of the range (inclusive).
     * @param end The ending index of the range (inclusive).
     * @return The smallest integer in the specified range.
     */
    public static int findMinInRange(int[] arr, int start, int end) {
        // --- Input Validation ---
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        if (start < 0 || end >= arr.length || start > end) {
            throw new IllegalArgumentException("Invalid range. Start must be less than end and within bounds.");
        }

        // Assume the first element in the range is the smallest
        int min = arr[start];

        // Loop through the rest of the elements in the range
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}