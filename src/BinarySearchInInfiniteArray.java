public class BinarySearchInInfiniteArray {
    public static int findTheTarget(int[] infiniteArray, int target) {
        int start = 0;
        int end = 1;

        // Find the range where the target might be present
        while (target > infiniteArray[end]) {
            int newStart = end + 1;
            // Double the range
            end = (end + 1) << 1;
            start = newStart;
        }

        // Perform binary search in the found range
        return binarySearch(infiniteArray, target, start, end);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] infiniteArray = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
        int target = 10;
        int resultIndex = findTheTarget(infiniteArray, target);
        if (resultIndex != -1) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
