public class StrategyPatternExample {

    // Step 2: Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Step 3: Concrete Strategy
    static class CreditCardPayment implements PaymentStrategy {

        public void pay(double amount) {
            System.out.println("Paid Rs." + amount +
                    " using Credit Card");
        }
    }

    // Step 3: Concrete Strategy
    static class PayPalPayment implements PaymentStrategy {

        public void pay(double amount) {
            System.out.println("Paid Rs." + amount +
                    " using PayPal");
        }
    }

    // Step 4: Context Class
    static class PaymentContext {

        private PaymentStrategy strategy;

        public PaymentContext(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(double amount) {
            strategy.pay(amount);
        }
    }

    // Step 5: Test Strategy Pattern
    public static void main(String[] args) {

        PaymentContext context;

        context = new PaymentContext(
                new CreditCardPayment());

        context.executePayment(5000);

        context = new PaymentContext(
                new PayPalPayment());

        context.executePayment(2500);
    }
}