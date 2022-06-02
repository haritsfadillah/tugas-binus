import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            // Ask user to input a word/sentence to be compared
            System.out.print("Masukkan Kalimat: ");
            String input = new Scanner(System.in).nextLine();

            // Print validation result
            // If the String inputted by the user is the same as its reversed form,
            // print "COOL" otherwise print "BAD"
            System.out.println(input.equalsIgnoreCase(new StringBuilder(input).reverse().toString()) ? "COOL" : "BAD");
        }
    }
}