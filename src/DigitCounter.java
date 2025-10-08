/**
 * A class to demonstrate counting the number of digits in an integer.
 */
public class DigitCounter {

    /**
     * Counts the number of digits in a given non-negative integer.
     *
     * @param number The non-negative integer whose digits are to be counted.
     * @return The number of digits in the integer.
     */
    public static int countDigits(int number) {
        // Handle the special case for 0, which has 1 digit.
        if (number == 0) {
            return 1;
        }

        // Ensure the number is positive for the counting logic
        // (though input validation should ideally handle negative numbers if they were allowed).
        int positiveNumber = Math.abs(number);

        // Method 1: Iterative approach (Division)
        
        int count = 0;
        while (positiveNumber > 0) {
            positiveNumber /= 10; // Remove the last digit
            count++;             // Increment the count
        }
        return count;
        

        // Method 2: Logarithmic approach (More efficient for very large numbers, but good for brevity)
        // The number of digits in a base-10 number 'n' is floor(log10(n)) + 1.
        //return (int) Math.floor(Math.log10(positiveNumber)) + 1;
    }

    /**
     * The main function to test the DigitCounter class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int number1 = 12345;
        int number2 = 987654321;
        int number3 = 0;
        int number4 = 7;
        int number5 = -54321; // Although the method is designed for non-negative, Math.abs handles this for demonstration

        System.out.println("The number of digits in " + number1 + " is: " + countDigits(number1));
        System.out.println("The number of digits in " + number2 + " is: " + countDigits(number2));
        System.out.println("The number of digits in " + number3 + " is: " + countDigits(number3));
        System.out.println("The number of digits in " + number4 + " is: " + countDigits(number4));
        System.out.println("The number of digits in " + number5 + " is: " + countDigits(number5));
        
        // Alternative method (converting to String) for comparison:
        System.out.println("\n--- String Method Comparison ---");
        int num_string = 10000;
        int string_count = String.valueOf(Math.abs(num_string)).length();
        System.out.println("The number of digits in " + num_string + " (via String conversion) is: " + string_count);
    }
}