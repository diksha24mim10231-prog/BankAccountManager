
import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int nextAccountNumber = 1;   // simple auto account number
        int choice;

        do {
            System.out.println("\n===== BANK ACCOUNT MANAGER =====");
            System.out.println("1. Create new account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Search account by number");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();   // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter opening balance: ");
                    double openingBalance = sc.nextDouble();
                    sc.nextLine();

                    BankAccount newAcc = new BankAccount(nextAccountNumber, name, openingBalance);
                    accounts.add(newAcc);

                    System.out.println("Account created successfully. Account Number = " + nextAccountNumber);
                    nextAccountNumber++;
                    break;

                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts to display.");
                    } else {
                        System.out.println("\n--- All Accounts ---");
                        for (BankAccount acc : accounts) {
                            acc.showDetails();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter account number to search: ");
                    int searchNo = sc.nextInt();
                    sc.nextLine();

                    BankAccount found = findAccount(accounts, searchNo);
                    if (found == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.println("Account found:");
                        found.showDetails();
                    }
                    break;

                case 4:
                    System.out.print("Enter account number for deposit: ");
                    int depNo = sc.nextInt();
                    sc.nextLine();

                    BankAccount depAcc = findAccount(accounts, depNo);
                    if (depAcc == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        depAcc.deposit(amount);
                    }
                    break;

                case 5:
                    System.out.print("Enter account number for withdrawal: ");
                    int wNo = sc.nextInt();
                    sc.nextLine();

                    BankAccount wAcc = findAccount(accounts, wNo);
                    if (wAcc == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double wAmount = sc.nextDouble();
                        sc.nextLine();
                        wAcc.withdraw(wAmount);
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // helper method to find account in list
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }
}
