package excercise1;

public class CreditCard extends PaymentMethod {

    private double creditLimit;

    public CreditCard(String accountHolder, double balance, double creditLimit) {
        super(accountHolder, balance); // MUST be first
        this.creditLimit = creditLimit;
        validateAccount();
    }

    @Override
    public void validateAccount() {
        if (creditLimit < 0) {
            creditLimit = 0;
        }
    }

    @Override
    public void processPayment(double amount) {
        if (amount > (balance + creditLimit)) {
            paymentStatus = "Transaction Declined";
            System.out.println("Transaction Declined.");
        } else {
            balance -= amount;
            totalTransactions++;
            paymentStatus = "Approved";
            System.out.println("CreditCard payment approved.");
        }
    }
}
