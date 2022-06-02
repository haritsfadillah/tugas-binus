import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean isRunning = true;
    static String name, nim;
    static int seqLength, totalNumber;

    enum SequenceType {
        Odd, Even, Fibonacci
    }

    public static void main(String[] args) {
        while (isRunning) {
            GetName();
            GetNim();

            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.println("Registrasi Sukses..");
            System.out.printf("Selamat datang %s (NIM : %s ).. ^^y\n", name, nim);
            System.out.println("\nMari Belajar macam-macam deret bilangan..");
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            GetNumber();
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.println("Deret Bilangan");
            System.out.println("###############");

            GenerateSequence(SequenceType.Even, seqLength);
            GenerateSequence(SequenceType.Odd, seqLength);
            GenerateSequence(SequenceType.Fibonacci, seqLength);

            GetRerunConfirmation();
        }
    }

    static void GetName() {
        System.out.print("Masukkan Nama Anda (1..25) : ");
        name = scanner.nextLine();

        // Validasi nama user
        // Jika gagal, lakukan recursive untuk meminta user menginput nama kembali
        if (name.length() > 25 || name.isEmpty()) {
            System.out.println("Maaf, panjang nama harus antara 1-25 karakter.");
            GetName();
        }
    }

    static void GetNim() {
        System.out.print("Masukkan NIM Anda (harus 10 karakter) : ");
        nim = scanner.nextLine();

        // Validasi NIM user
        // Jika gagal, lakukan recursive untuk meminta user menginput NIM kembali
        if (nim.length() != 10) {
            System.out.println("Maaf, format NIM harus memiliki 10 karakter");
            GetNim();
        }
    }

    static void GetNumber() {
        System.out.print("Masukkan Sembarang Angka (5..20) : ");
        seqLength = scanner.nextInt();
        scanner.nextLine();

        // Validasi angka yang dimasukkan oleh user
        // Jika gagal, lakukan recursive untuk meminta user menginput angka kembali
        if (seqLength < 5 || seqLength > 20) {
            System.out.println("Maaf, mohon masukkan angka antara 5-20");
            GetNumber();
        }
    }

    static void GenerateSequence(SequenceType sequenceType, int sequenceLength) {
        switch (sequenceType) {
            case Odd:
                System.out.printf("%s Bilangan %s :\n", sequenceLength, "Ganjil");
                PrintArithmeticSequence(1, sequenceLength);
                break;
            case Even:
                System.out.printf("%s Bilangan %s :\n", sequenceLength, "Genap");
                PrintArithmeticSequence(2, sequenceLength);
                break;
            case Fibonacci:
                System.out.printf("%s Bilangan %s :\n", sequenceLength, "Fibonacci");
                PrintFibonacciSequence(sequenceLength);
                break;
        }

        System.out.printf("Hasil Penjumlahan = %d\n\n", totalNumber);
    }

    static void PrintArithmeticSequence(int startNumber, int length) {
        totalNumber = 0;

        for (int i = 1; i <= length; i++) {

            int currentNumber = startNumber + ((i - 1) * 2);

            if (i == length) {
                System.out.print(currentNumber + "\n");
            } else {
                System.out.print(currentNumber + " ");
            }

            totalNumber = totalNumber + currentNumber;
        }
    }

    static void PrintFibonacciSequence(int length) {
        int n1 = 0, n2 = 1, n3;

        System.out.print(n1 + " " + n2);//printing 0 and 1

        totalNumber = 1;
        for (int i = 2; i <= length; ++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;

            if (i == length) {
                System.out.print(n3 + "\n");
            } else {
                System.out.print(n3 + " ");
            }

            totalNumber = totalNumber + n3;

            n1 = n2;
            n2 = n3;
        }
    }

    // Method untuk meminta konfirmasi user
    // apakah akan mengulang aplikasi atau tidak
    static void GetRerunConfirmation() {
        String userSelection;

        // Meminta user menginput pilihan
        System.out.print("Anda ingin mengulang (y/t) : ");
        userSelection = scanner.nextLine();

        switch (userSelection.toLowerCase()) {
            case "y":
                isRunning = true;
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