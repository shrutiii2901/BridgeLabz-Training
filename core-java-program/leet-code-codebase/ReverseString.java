 class Main {
    public static void main(String[] args) {
        String originalStr = "Hello World";
        // Create a StringBuilder object and append the original string
        StringBuilder reversedStr = new StringBuilder(originalStr);

        // Use the built-in reverse() method
        reversedStr.reverse();

        // Convert the StringBuilder back to a String and print the result
        System.out.println("Original String: " + originalStr);
        System.out.println("Reversed String: " + reversedStr.toString());
    }
}
