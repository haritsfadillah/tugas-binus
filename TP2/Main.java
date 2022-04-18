import java.util.Scanner;

public class Main {
    // global fields
    static int PrintN;
    static int Difference;
    static Scanner scanner = new Scanner(System.in);
    static boolean isRunning = true;

    public static void main(String[] args) {
        while (isRunning) {
            try {
                System.out.println("Belajar Deret Aritmatika, Geometri dan menghitung Faktorial\n");

                // Prompt user input for number to print and sequence difference
                GetPrintNInput();
                GetDifferenceInput();

                // Generate and print sequence numbers (arithmentic, geometric, & factorial)
                Sequence sequence = new Sequence(PrintN, Difference);
                sequence.GenerateSequences();

                // Prompt user confirmation to rerun the app
                scanner = new Scanner(System.in);
                GetRerunConfirmation();
            } catch (Exception ex) {
                System.out.println("Mohon maaf, aplikasi tidak dapat mengkalkulasi menggunakan input yang anda berikan.");
            }
        }
    }

    private static void GetPrintNInput() {
        // Prompt the user to provide input for n (number to be print)
        System.out.printf("Masukkan banyak angka yang mau dicetak (2..10)%-1s: ", " ");
        PrintN = scanner.nextInt();

        // Validate user input
        // if printN is less than 2 and greater than 10, the apps will prompt the user to re-input a number
        if (PrintN < 2 || PrintN > 10) {
            System.out.println("Mohon maaf, angka yang anda masukkan tidak valid.");
            System.out.println("Angka yang dapat dimasukkan minimal 2 dan maksimal 10.\n");

            // Recursive
            GetPrintNInput();
        }
    }

    private static void GetDifferenceInput() {
        // Prompt the user to provide input for the difference
        System.out.printf("Masukkan beda masing-masing angka (2..9)%-7s: ", " ");
        Difference = scanner.nextInt();

        // Validate user input
        // if printN is less than 2 and greater than 9, the apps will prompt the user to re-input a number
        if (Difference < 2 || Difference > 10) {
            System.out.println("Mohon maaf, angka yang anda masukkan tidak valid.");
            System.out.println("Angka yang dapat dimasukkan minimal 2 dan maksimal 9.\n");

            // Recursive
            GetDifferenceInput();
        }
    }

    // Method untuk meminta konfirmasi user
    // apakah akan mengulang aplikasi atau tidak
    static void GetRerunConfirmation() {
        String userSelection;

        // Meminta user menginput pilihan
        System.out.print("\nAnda mau ulang (y/t) : ");
        userSelection = scanner.nextLine();

        switch (userSelection.toLowerCase()) {
            case "y":
                isRunning = true;
                System.out.println();
                break;
            case "t":
                isRunning = false;
                break;
            default:
                System.out.println("Maaf anda hanya bisa memilih antara 'y' atau 't'");
                break;
        }
    }
}

class Sequence {
    // First number of the sequence
    int a = 1;

    private final int _printN;
    private final int _difference;

    public Sequence(int printN, int difference) {
        _printN = printN;
        _difference = difference;
    }

    public void GenerateSequences() {
        PrintArithmeticSequence();
        PrintGeometricSequence();
        PrintFactorial();
    }

    public void PrintArithmeticSequence() {
        System.out.println("Deret Aritmatika : ");

        for (int i = 1; i <= _printN; i++) {
            if (i < _printN) {
                System.out.print(GetArithmeticValue(i, _difference) + " ");
            } else {
                System.out.println(GetArithmeticValue(i, _difference));
            }
        }
    }

    public void PrintGeometricSequence() {
        System.out.println("Deret Geometri : ");

        for (int i = 1; i <= _printN; i++) {
            if (i < _printN) {
                System.out.print(GetGeometricValue(i, _difference) + " ");
            } else {
                System.out.println(GetGeometricValue(i, _difference));
            }
        }
    }

    public void PrintFactorial() {
        System.out.println("Faktorial dari " + _printN + " : ");

        for (int i = _printN; i >= 1; i--) {
            if (i > 1) {
                System.out.print(i + " x ");
            } else {
                System.out.println(i + " = " + GetFactorialValue(_printN));
            }
        }
    }

    private int GetArithmeticValue(int n, int difference) {
        return a + (n - 1) * difference;
    }

    private int GetGeometricValue(int n, int difference) {
        return (int) (a * Math.pow(difference, n - 1));
    }

    private int GetFactorialValue(int n) {
        return (n == 1 || n == 0) ? 1 : n * GetFactorialValue(n - 1);
    }
}