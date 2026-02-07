package excercise1;

public abstract class PaymentMethod implements Payable {

    protected String accountHolder;
    protected double balance;

    protected String paymentStatus = "Not processed";

    protected static int totalTransactions = 0;

    public PaymentMethod(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void validateAccount();

    @Override
    public String getPaymentStatus() {
        return paymentStatus;
    }
}
