public class FindPeakIndexMountainArray {
    public static int findPeakNumber(int[] mountainArray) {

        int length = mountainArray.length;
        int start = 1;
        int end = length - 2;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int potentialAnswer = mountainArray[mid];
            int rightToPa = mountainArray[mid+1];
            int leftToPa = mountainArray[mid-1];

            if (potentialAnswer > rightToPa && potentialAnswer > leftToPa) {
                return mid;
            }
            else if (potentialAnswer > rightToPa && potentialAnswer < leftToPa) {
                end = mid-1;
            }
            else if (potentialAnswer < rightToPa && potentialAnswer > leftToPa) {
                start = mid+1;
            }
        }

        return start;
    }
    public static void main(String[] args) {
        int[] mountainArray = {1,3,4,5,22,7,6,4,2};
        System.out.println(findPeakNumber(mountainArray));
    }
}
