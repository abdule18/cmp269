package excercise1;

public class MealPlan extends PaymentMethod {

    public MealPlan(String accountHolder, double balance) {
        super(accountHolder, balance);
        validateAccount();
    }

    @Override
    public void validateAccount() {
        if (balance < 0) {
            balance = 0;
        }
    }

    @Override
    public void processPayment(double amount) {
        if (amount > balance) {
            paymentStatus = "Transaction Declined";
            System.out.println("MealPlan Declined: Insufficient balance.");
        } else {
            balance -= amount;
            totalTransactions++;
            paymentStatus = "Approved";
            System.out.println("MealPlan payment approved.");
        }
    }
}
