import java.util.*;

public class Main{
    public static void main(String[] args){        
        String username, itemName;
        int itemQty;
        double buyingPrice, sellingPrice;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama anda : ");
        username = scanner.nextLine();

        System.out.println("\nStok Gudang Input Barang");
        System.out.println("##########################");

        System.out.println("\nSelamat Datang Andi");

        System.out.print("Masukkan nama barang yang mau ditambah : ");
        itemName = scanner.nextLine();
        System.out.print("Masukkan jumlah barang yang mau ditambah : ");
        itemQty = scanner.nextInt();
        System.out.print("Masukkan harga beli untuk barang tersebut : ");
        buyingPrice = scanner.nextDouble();
        System.out.print("Masukkan harga jual untuk barang tersebut : ");
        sellingPrice = scanner.nextDouble();

        System.out.println("\nStok Gudang Rincian Barang");
        System.out.println("############################\n");
        System.out.println("Nama Barang   : " + itemName);
        System.out.println("Jumlah Barang : " + itemQty);
        System.out.println("Harga Beli    : " + String.format("%.2f",buyingPrice));
        System.out.println("Harga Jual    : " + String.format("%.2f",sellingPrice));
    }
}