public class BinarySearchFirstLast {
    public static int findFirstOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if ((mid == arr.length - 1 || arr[mid + 1] > target) && arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static int[] returnFirstAndLastoccurence(int[] arr, int target) {
        return new int[] { findFirstOccurrence(arr, target), findLastOccurrence(arr, target) };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 4, 4, 5 };
        int target = 2;
        int[] firstAndLast = returnFirstAndLastoccurence(arr, target);
        System.out.println("First index: " + firstAndLast[0] + ", Last index: " + firstAndLast[1]);
    }
}