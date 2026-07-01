public class AdapterPatternExample {

    // Step 2: Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 3: Adaptee Classes

    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of Rs." + amount + " processed through PayPal");
        }
    }

    static class StripeGateway {
        public void pay(double amount) {
            System.out.println("Payment of Rs." + amount + " processed through Stripe");
        }
    }

    // Step 4: Adapter Classes

    static class PayPalAdapter implements PaymentProcessor {

        private PayPalGateway paypal;

        public PayPalAdapter(PayPalGateway paypal) {
            this.paypal = paypal;
        }

        public void processPayment(double amount) {
            paypal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {

        private StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.pay(amount);
        }
    }

    // Step 5: Test Adapter Pattern

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripe =
                new StripeAdapter(new StripeGateway());

        paypal.processPayment(1000);
        stripe.processPayment(2000);
    }
}
