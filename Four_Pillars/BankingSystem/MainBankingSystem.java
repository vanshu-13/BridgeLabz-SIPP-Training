import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBankingSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.println("Enter number of accounts:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter account type (1-Savings, 2-Current):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter account number:");
            String accountNumber = s.nextLine();

            System.out.println("Enter holder name:");
            String holderName = s.nextLine();

            System.out.println("Enter balance:");
            double balance = s.nextDouble();
            s.nextLine();

            BankAccount account = null;
            switch (type) {
                case 1:
                    account = new SavingsAccount(accountNumber, holderName, balance);
                    break;
                case 2:
                    account = new CurrentAccount(accountNumber, holderName, balance);
                    break;
                default:
                    System.out.println("Invalid account type.");
                    i--;
                    continue;
            }
            accounts.add(account);
        }

        System.out.println("\nAccount Details with Interest:");
        for (BankAccount acc : accounts) {
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Holder Name: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
