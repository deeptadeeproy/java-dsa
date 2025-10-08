public class LinearSearch {
    public static void main(String[] args) throws Exception {
        String name = "Deeptadeep";
        char targetChar = 'a';
        System.out.println(search(name, targetChar));

    }

    static boolean search(String string, char target) {
        if (string.length() == 0) {
            return false;
        }

        for (char ch : string.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }

        return false;
    }
}
