public class BinarySearch {
    public static void main(String[] args) {
        int target = 10;
        int[] sortedArray = { 1, 3, 6, 10, 19, 32 };

        int start = 0;
        int end = sortedArray.length - 1;

        System.out.println(findMe(target, sortedArray, start, end));
    }

    private static String findMe(int targetNumber, int[] sortedArray, int startIndex, int endIndex) {
        // Validate indices
        if (startIndex < 0 || endIndex >= sortedArray.length || startIndex > endIndex) {
            return "-1";
        }

        int left = startIndex;
        int right = endIndex;

        while (left <= right) {
            int middleIndex = (left + right) >>> 1; // Safe from integer overflow
            int midValue = sortedArray[middleIndex];

            if (midValue == targetNumber) {
                return "Found " + targetNumber + " at index " + middleIndex + ".";
            } else if (midValue > targetNumber) {
                right = middleIndex - 1;
            } else {
                left = middleIndex + 1;
            }
        }

        return "-1";
    }

}
