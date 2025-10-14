import java.util.Objects;

public class BinarySearch {
    public static void main(String[] args) {
        var target = 10;
        var sortedArray = new int[]{ 1, 3, 6, 10, 19, 32 };

        var start = 0;
        var end = sortedArray.length - 1;

        System.out.println(findMe(target, sortedArray, start, end));
    }

    private static String findMe(int targetNumber, int[] sortedArray, int startIndex, int endIndex) {
        // Validate input
        Objects.requireNonNull(sortedArray, "Array cannot be null");

        // Validate indices
        if (startIndex < 0 || endIndex >= sortedArray.length || startIndex > endIndex) {
            return "-1";
        }

        var left = startIndex;
        var right = endIndex;

        // Determine if the array is sorted in ascending or descending order
        boolean isAscending = sortedArray[left] < sortedArray[right];

        while (left <= right) {
            var middleIndex = (left + right) >>> 1; // Safe from integer overflow
            var midValue = sortedArray[middleIndex];

            if (midValue == targetNumber) {
                return "Found " + targetNumber + " at index " + middleIndex + ".";
            }

            if (isAscending) {
                if (midValue > targetNumber) {
                    right = middleIndex - 1;
                } else {
                    left = middleIndex + 1;
                }
            } else {
                if (midValue < targetNumber) {
                    right = middleIndex - 1;
                } else {
                    left = middleIndex + 1;
                }
            }
        }

        return "-1";
    }

}
