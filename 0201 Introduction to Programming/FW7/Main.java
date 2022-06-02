import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int _powerValue;

    public static void main(String[] args) {
        GetUserInput();
        System.out.printf("Jawabannya : %d", sumOfPowerValueNumbers(_powerValue));
    }

    public static void GetUserInput() {
        System.out.print("Masukkan nilai x : ");
        _powerValue = scanner.nextInt();
    }

    private static int TwoPowerValue(int powerValue) {
        return (int) Math.pow(2, powerValue);
    }

    public static int sumOfPowerValueNumbers(int powerValue) {
        char[] powerValueNumbers = Integer.toString(TwoPowerValue(powerValue)).toCharArray();
        int result = 0;

        for (char number : powerValueNumbers) {
            result += Integer.parseInt(String.valueOf(number));
        }

        return result;
    }
}
