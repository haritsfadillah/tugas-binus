import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("Welcome to CoePoe Bank CLI Apps");
        System.out.println("********************************************");
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name = sc.nextLine();
        String customerId = sc.nextLine();
        BankAccount account = new BankAccount(name, customerId);
        account.PerformAction();
    }
}

class BankAccount {
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }


    void deposit(double amount) {
        if (amount != 0) {
            bal += amount;
            prevTrans = amount;
        }
    }

    void withdraw(double amt) {
        if (amt != 0 && bal >= amt) {
            bal -= amt;
            prevTrans = -amt;
        } else if (bal < amt) {
            System.out.println("Bank balance insufficient");
        }
    }

    void getPreviousTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrawn: " + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void PerformAction() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID:" + customerId);
        System.out.println("\n");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            System.out.println("a) Check Balance");
            System.out.println("b) Deposit Amount");
            System.out.println("c) Withdraw Amount");
            System.out.println("d) Previous Transaction");
            System.out.println("e) Exit");
            option = sc.next().charAt(0);
            System.out.println("\n");

            DecimalFormat df = new DecimalFormat();
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator('.');
            symbols.setGroupingSeparator(',');
            df.setDecimalFormatSymbols(symbols);

            switch (option) {
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balance = " + df.format(bal));
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amt = sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amtW = sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case 'd':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        } while (option != 'e');

        System.out.println("Thank you for using our banking services");
    }
}
