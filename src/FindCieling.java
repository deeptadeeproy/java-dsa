import java.util.Objects;

public class FindCieling {
    public static int findCeiling(int[] sortedArray, int target) {
        // Validate input
        Objects.requireNonNull(sortedArray, "Array cannot be null");
        if (sortedArray.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int left = 0;
        int right = sortedArray.length - 1;

        // If the target is greater than the largest element
        if (target > sortedArray[right]) {
            return -1; // No ceiling exists
        }

        while (left <= right) {
            int middle = (left + right) >>> 1;

            if (sortedArray[middle] == target) {
                return sortedArray[middle]; // Exact match
            } else if (sortedArray[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        // Left will point to the smallest number greater than or equal to the target
        return sortedArray[left];
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        int target = 6;

        int ceiling = findCeiling(sortedArray, target);
        if (ceiling != -1) {
            System.out.println("The ceiling of " + target + " is " + ceiling);
        } else {
            System.out.println("No ceiling found for " + target);
        }
    }
}
