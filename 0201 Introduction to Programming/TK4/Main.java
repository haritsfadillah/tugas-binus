import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static boolean IsRunning = true;
    private static Scanner scanner = new Scanner(System.in);

    private static enum SortType {
        Bubble,
        Selection
    }

    private static enum SortDirection {
        Ascending,
        Descending
    }

    public static void main(String[] args) {
        while (IsRunning) {

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

            if (isValidMenu(selectedMenu)) {
                if (selectedMenu == 6) {
                    IsRunning = false;
                } else {
                    System.out.print("Batas Bawah = ");
                    int lBound = scanner.nextInt();

                    System.out.print("Batas Atas = ");
                    int uBound = scanner.nextInt();

                    // Initialize array to store the random numbers
                    ArrayList<Integer> numbers = new ArrayList<>();
                    switch (selectedMenu) {
                        case 1:
                            // Generate 5 random numbers
                            for (int i = 1; i <= 5; i++) {
                                getRandomNumbers(numbers, lBound, uBound);
                            }

                            System.out.printf("%d %d %d %d %d",
                                    numbers.get(0),
                                    numbers.get(1),
                                    numbers.get(2),
                                    numbers.get(3),
                                    numbers.get(4)
                            );

                            break;
                        case 2:
                            Sort(numbers, SortType.Bubble, SortDirection.Ascending);
                            break;
                        case 3:
                            Sort(numbers, SortType.Selection, SortDirection.Ascending);
                            break;
                        case 4:
                            Sort(numbers, SortType.Bubble, SortDirection.Descending);
                            break;
                        case 5:
                            Sort(numbers, SortType.Selection, SortDirection.Descending);
                            break;
                    }
                }
            } else {
                System.out.println("Menu yang anda input tidak valid!\n\n");
            }

            getRerunConfirmation();
        }
    }

    // Method to generate list of random numbers
    private static ArrayList<Integer> getRandomNumbers(ArrayList<Integer> numCollection, int lBound, int uBound) {
        // Generate random number
        int randNumber = (int) (Math.random() * (uBound - lBound)) + lBound;

        // Check if the generated number is exists in the array
        if (numCollection.contains(randNumber)) {

            // Perform recursive to generate new random number
            getRandomNumbers(numCollection, lBound, uBound);
        } else {

            // Add the generated number into the array
            numCollection.add(randNumber);
        }

        return numCollection;
    }

    private static boolean isValidMenu(int selectedMenu) {
        return selectedMenu >= 1 && selectedMenu <= 6;
    }

    private static void Sort(ArrayList<Integer> numbers, SortType sortType, SortDirection sortDirection) {
        if (numbers.isEmpty()){
            //generate random nummber
            return;
            }

        if ( sortType == SortType.Bubble ){
            if (sortDirection == SortDirection.Ascending){
                // perform bubble ascinding
            } else{
                // perform bubble descending
            }
        } else {
            if (sortDirection == SortDirection.Ascending){
                // perform insertion Ascending
            } else {
                //perfrom insertion descending
            }
        }
    
    }

    private static void getRerunConfirmation() {
        scanner = new Scanner(System.in);

        System.out.println("\nApakah anda mau mengulang? (y/t)");
        String userSelection = scanner.nextLine().toLowerCase();

        if (userSelection.length() > 1 || (!userSelection.equalsIgnoreCase("y") && !userSelection.equalsIgnoreCase("t"))) {
            System.out.println("Opsi yang dapat anda masukkan hanyalah 'y' atau 't')");
            getRerunConfirmation();
        }

        if (userSelection.equalsIgnoreCase("t")) {
            IsRunning = false;
        }
    }
}
