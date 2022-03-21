import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input
        int random, tebak, jumlah;

        random = (int) (Math.random() * 100);
        System.out.println("Tebaklah Angka Antara 1-100");
        Scanner masukan = new Scanner(System.in);

        jumlah = 0;

        //Proses
        do {
            jumlah++;

            System.out.print("Masukkan Tebakan Anda : ");
            tebak = masukan.nextInt();

            //Output
            if (tebak > random) {
                System.out.println("Tebakan Terlalu Besar");
            } else if (tebak < random) {
                System.out.println("Tebakan Terlalu Kecil");
            } else {
                System.out.print("Tebakan Benar! Setelah " + jumlah + " Kali Menebak");
            }
        } while (tebak != random);
    }
}