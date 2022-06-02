import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Menginisiasi Scanner class untuk membaca input
        Scanner scanner = new Scanner(System.in);

        // Menginisiasi variable jumlah orang dalam 1 group
        int groupQty;

        // Minta user menginput jumlah orang & nama pemesan
        System.out.println("Selamat siang...");
        System.out.printf("%-25s : ", "Pesan untuk berapa orang");
        groupQty = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("%-25s : ", "Pesanan atas nama");

        // Menginisiasi menu makanan
        List<MenuMakanan> menu = new ArrayList<>();
        menu.add(new MenuMakanan("Nasi Goreng Spesial", 9999.99));
        menu.add(new MenuMakanan("Ayam Bakar Spesial", 12345.67));
        menu.add(new MenuMakanan("Steak Sirloin Spesial ", 21108.40));
        menu.add(new MenuMakanan("Kwetiaw Siram ", 13579.13));
        menu.add(new MenuMakanan("Kambing Guling Spesial", 98765.43));

        // Menunjukan menu makanan hari ini
        System.out.println("\nMenu Spesial hari ini");
        System.out.println("#####################");

        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("\t%d. %-30s Rp. %.2f\n",
                    (i + 1), menu.get(i).GetName(), menu.get(i).GetPrice());
        }

        // Menginisiasi variable untuk mencatat order customer
        List<Pair<MenuMakanan, Integer>> orders = new ArrayList<>();

        // Minta user untuk memasukkan jumlah yang akan dipesan untuk setiap item
        System.out.println("\nPesanan Anda [batas pesanan 0-10 po]");

        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %-25s : ", (i + 1), menu.get(i).GetName());
            orders.add(new Pair<>(menu.get(i), scanner.nextInt()));
        }

        //
        System.out.println("\n\nSelamat menikmati makanan anda...");

        // Menampiilan struk pembelian
        System.out.println("\nPembelian:");

        double totalPrice = 0;

        // 1. Memunculkan sub total harga per item makanan
        // 2. Menyimpan total harga dari order
        for (int i = 0; i < orders.size(); i++) {
            String menuItem;
            double itemPrice, subTotal;
            int orderQty;

            menuItem = orders.get(i).getKey().GetName();
            itemPrice = orders.get(i).getKey().GetPrice();
            orderQty = orders.get(i).getValue();
            subTotal = itemPrice * orderQty;

            totalPrice = totalPrice + subTotal;

            System.out.printf("%d. %-25s %d porsi x Rp. %.2f = Rp. %.2f%n",
                    (i + 1), menuItem, orderQty, itemPrice, subTotal);
        }

        System.out.println("##########################################################");
        System.out.printf("%-50s = Rp. %.2f%n", "Total Pembelian", totalPrice);

        // Menampilan discount dan total harga setelah discount
        double discount = totalPrice * .1;
        System.out.printf("%-50s = Rp. %.2f%n", "Disc. 10% (Masa Promosi)", discount);
        System.out.println("##########################################################");
        System.out.printf("%-50s = Rp. %.2f%n", "Total Pembelian setelah disc. 10%", totalPrice - discount);

        // Menampilkan harga per orang dari total harga setelah discount
        double pricePerPerson = (totalPrice - discount) / groupQty;
        System.out.printf("Pembelian per orang (untuk %d orang) %-10s = Rp. %.2f%n", groupQty, "", pricePerPerson);
    }

    // Class untuk merepresntasikan menu makanan
    public static class MenuMakanan {
        private final String _name;
        private final double _price;

        public MenuMakanan(String name, double price) {
            this._name = name;
            this._price = price;
        }

        public String GetName() {
            return this._name;
        }

        public double GetPrice() {
            return this._price;
        }
    }
}