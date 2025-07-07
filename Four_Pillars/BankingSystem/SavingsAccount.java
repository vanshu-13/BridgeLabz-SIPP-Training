public class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04; // 4% interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}
