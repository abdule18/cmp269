package excercise1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Payable> paymentQueue = new ArrayList<>();

        paymentQueue.add(new CreditCard("Student One", 25.0, 100.0));
        paymentQueue.add(new MealPlan("Student Two", 40.0));

        for (Payable p : paymentQueue) {
            p.processPayment(50.0);
            System.out.println("Status: " + p.getPaymentStatus());
            System.out.println("-----");
        }

        System.out.println("Total Transactions: " + PaymentMethod.totalTransactions);
    }
}
