package com.bridgelaz;

import java.util.ArrayList;
import java.util.List;

// Bank class: Associated with customers
class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Customer opens an account with this bank
    public void openAccount(Customer customer) {
        customers.add(customer);
        customer.setBank(this);
        System.out.println("Account opened for " + customer.getName() + " at " + name);
    }

    public String getName() {
        return name;
    }
}

// Customer class: Associated with Bank
class Customer {
    private String name;
    private Bank bank;
    private double balance;

    public Customer(String name, double initialBalance) {
        this.name = name;
        this.balance = initialBalance;
    }

    // Sets the bank during association
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    // View balance and bank info
    public void viewBalance() {
        System.out.println(name + " has ₹" + balance + " in " + bank.getName());
    }
}

// Demonstration class
public class BankAssociationDemo {
    public static void main(String[] args) {
        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        Customer c1 = new Customer("Amit", 5000);
        Customer c2 = new Customer("Neha", 8000);

        sbi.openAccount(c1);
        hdfc.openAccount(c2);

        c1.viewBalance();
        c2.viewBalance();
    }
}
