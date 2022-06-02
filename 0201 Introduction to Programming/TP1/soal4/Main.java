import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String namaRequestor, namaPasangan;
        int umurRequestor, umurPasangan;
        
        System.out.println("Selamat Datang Di Program Ramalan Cupu");
        System.out.println("++++++++++++++++++++++++++++++++++++++");

        System.out.println("\nData Anda :");
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥");
        System.out.print("Masukkan Nama Anda : ");
        namaRequestor = scanner.nextLine();
        System.out.print("Masukkan Umur Anda : ");
        umurRequestor = scanner.nextInt();
        
        scanner.nextLine();
        System.out.println("\nData Pasangan Anda :");
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
        System.out.print("Masukkan Nama Pasangan Anda : ");
        namaPasangan = scanner.nextLine();
        System.out.print("Masukkan Umur Pasangan Anda : ");
        umurPasangan = scanner.nextInt();

        System.out.println("\n" + namaRequestor + " " + "[" + umurRequestor + "] tahun\n");  
        System.out.println("  ♥♥♥    ♥♥♥  ");
        System.out.println(" ♥♥♥♥♥  ♥♥♥♥♥ ");
        System.out.println(" ♥♥♥♥♥♥♥♥♥♥♥♥ ");
        System.out.println("  ♥♥♥♥♥♥♥♥♥♥  ");
        System.out.println("   ♥♥♥♥♥♥♥♥   ");
        System.out.println("    ♥♥♥♥♥♥    ");
        System.out.println("     ♥♥♥♥     ");
        System.out.println("      ♥♥      ");
        System.out.println("\n" + namaPasangan + " " + "[" + umurPasangan + "] tahun");

        System.out.println("\nTekan ENTER untuk melihat hasil ramalan...");
        new Scanner(System.in).nextLine();
        System.out.println("\nMencocokan anda dengan pasangan anda adalah : " + String.format("%.02f",(new Random().nextInt(100 - 50 + 1) + 50)/1.1) + " %");
        System.out.println("\n\n\nTerima kasih karena anda telah menggunakan jasa Ramalan kami.. ^^v");  
    }
}