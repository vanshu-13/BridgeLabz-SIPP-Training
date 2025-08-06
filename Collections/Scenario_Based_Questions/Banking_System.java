package GENERICS.Collections.Scenario_Based_Questions;

import java.util.*;

public class Banking_System {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedByBalance.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            double currentBalance = accounts.get(acc);
            if (currentBalance >= amount) {
                updateSortedBalance(acc, currentBalance, currentBalance - amount);
                accounts.put(acc, currentBalance - amount);
                System.out.println("Withdrawal of ₹" + amount + " successful for account: " + acc);
            } else {
                System.out.println("Insufficient funds for account: " + acc);
            }
        }
    }

    private void updateSortedBalance(String acc, double oldBalance, double newBalance) {
        sortedByBalance.get(oldBalance).remove(acc);
        if (sortedByBalance.get(oldBalance).isEmpty()) {
            sortedByBalance.remove(oldBalance);
        }
        sortedByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(acc);
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println("Account: " + acc + ", Balance: ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Banking_System bank = new Banking_System();
        bank.createAccount("ACC123", 5000);
        bank.createAccount("ACC456", 3000);
        bank.createAccount("ACC789", 7000);

        bank.requestWithdrawal("ACC123");
        bank.requestWithdrawal("ACC456");

        bank.processWithdrawals(1000);
        System.out.println();
        bank.displaySortedAccounts();
    }
}

