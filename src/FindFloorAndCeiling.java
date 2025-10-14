import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Objects;

public class FindFloorAndCeiling {
    public static Entry<Integer, Integer> findFloorAndCeiling(int[] sortedArray, int target) {
        // Validate input
        Objects.requireNonNull(sortedArray, "Array cannot be null");
        if (sortedArray.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int left = 0;
        int right = sortedArray.length - 1;
        int floor = -1;
        int ceiling = -1;

        while (left <= right) {
            int middle = (left + right) >>> 1;

            if (sortedArray[middle] == target) {
                return new SimpleEntry<>(sortedArray[middle], sortedArray[middle]); // Exact match
            } else if (sortedArray[middle] < target) {
                floor = sortedArray[middle];
                left = middle + 1;
            } else {
                ceiling = sortedArray[middle];
                right = middle - 1;
            }
        }

        return new SimpleEntry<>(floor, ceiling);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        int target = 6;

        Entry<Integer, Integer> result = findFloorAndCeiling(sortedArray, target);

        if (result.getValue() != -1) {
            System.out.println("The ceiling of " + target + " is " + result.getValue());
        } else {
            System.out.println("No ceiling found for " + target);
        }

        if (result.getKey() != -1) {
            System.out.println("The floor of " + target + " is " + result.getKey());
        } else {
            System.out.println("No floor found for " + target);
        }
    }
}
