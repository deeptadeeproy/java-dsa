public class CeilingofaTargetLetter {
    public static char findCeilingOfTargetLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        
        int length = letters.length;
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % length];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'j';
        char ceiling = findCeilingOfTargetLetter(letters, target);
        System.out.println("The ceiling of '" + target + "' is '" + ceiling + "'");
    }

}
