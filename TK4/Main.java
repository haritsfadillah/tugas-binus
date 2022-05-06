import java.util.Scanner;

public class Main{
    private static boolean IsRunning = true;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        while (IsRunning){

        System.out.println("Selamat datang di Program Simulasi");
        System.out.println("Menu");
        System.out.println("1. Random Data");
        System.out.println("2. Simulasi Bubble Sort - Ascending");
        System.out.println("3. Simulasi Selection Sort - Ascending");
        System.out.println("4. Simulasi Bubble Sort - Descending");
        System.out.println("5. Simulasi Selection Sort - Descending");
        System.out.println("6. Keluar");
        System.out.println("Masukkan Pilihan Anda");

        int selectedMenu = scanner.nextInt();

        if (isValidMenu(selectedMenu)){
          if (selectedMenu != 6){

           }
        }
        else{
            System.out.println("Menu yang anda input tidak valid!\n\n");
        }

        getRerunConfirmation();
        }          
    }

    private static boolean isValidMenu(int selectedMenu){
        return selectedMenu >= 1 && selectedMenu <= 6;
    }

    private static void runSimulation(int selectedMenu){
    }

    private static void getRerunConfirmation(){
        scanner = new Scanner(System.in);

        System.out.println("\nApakah anda mau mengulang? (y/t)");
        String userSelection = scanner.nextLine().toLowerCase();
        
        
        if (userSelection == "t"){
            IsRunning = false;
        }else if (userSelection.length() > 1 || (userselection != "y" && userselection != "t")){
            System.out.println("Opsi yang dapat anda masukkan hanyalah 'y' atau 't');

        if (userSelection == "t"){
            IsRunning = false;
        }else if (userSelection.Length > 1 || (userselection != "y" && userselection != "t")){
            System.out.println("Opsi yang dapat anda masukkan hanyalah 'y' atau 't');

    }

}
