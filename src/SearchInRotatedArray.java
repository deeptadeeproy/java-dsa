public class SearchInRotatedArray {
    public static void main(String[] args) {
        int target = 14;
        int[] rotatedArray = new int[] { 12, 13, 14, 1, 4, 8, 10, 11 };

        int start = 0;
        int end = rotatedArray.length - 1;

        int indexOfTarget = findTargetInRotatedArray(target, rotatedArray, start, end);

        if (indexOfTarget != -1) {
            System.out.println("Element found at index: " + indexOfTarget);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    private static int findTargetInRotatedArray(int target, int[] rotatedArray, int start, int end) {

        while (start <= end) {
            int middleIndex = (start + end) >>> 1;
            int startingValue = rotatedArray[start];
            int endingValue = rotatedArray[end];
            int middleValue = rotatedArray[middleIndex];

            if (middleValue == target) {
                return middleIndex;
            }

            if (startingValue <= middleValue) {
                // Left side is sorted
                if (target >= startingValue && target < middleValue) {
                    end = middleIndex - 1;
                } else {
                    start = middleIndex + 1;
                }
            } else {
                // Right side is sorted
                if (target > middleValue && target <= endingValue) {
                    start = middleIndex + 1;
                } else {
                    end = middleIndex - 1;
                }
            }

        }

        return -1;
    }
}
