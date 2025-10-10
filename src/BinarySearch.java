public class BinarySearch {
    public static void main(String[] args) {
        int target = 10;
        int[] sortedArray = { 1, 3, 6, 10, 19, 32 };

        int start = 0;
        int end = sortedArray.length - 1;

        System.out.println(findMe(target, sortedArray, start, end));
    }

    private static String findMe(int targetNumber, int[] sortedArray, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return String.valueOf(-1);
        }

        if (endIndex >= sortedArray.length) {
            return String.valueOf(-1);
        }

        if (startIndex == endIndex) {
            if (sortedArray[startIndex] == targetNumber) {
                return ("Found " + targetNumber + " at index " + startIndex + ".");
            }
            return String.valueOf(-1);
        }

        int middleIndex = (startIndex + endIndex) / 2;

        if (sortedArray[middleIndex] == targetNumber) {
            return ("Found " + targetNumber + " at index " + middleIndex + ".");
        }
        if (sortedArray[middleIndex] > targetNumber) {
            return findMe(targetNumber, sortedArray, startIndex, middleIndex - 1);
        }
        if (sortedArray[middleIndex] < targetNumber) {
            return findMe(targetNumber, sortedArray, middleIndex + 1, endIndex);
        }
        return String.valueOf(-1);
    }
}
