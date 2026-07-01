public class DecoratorPatternExample {

    // Step 2: Component Interface
    interface Notifier {
        void send(String message);
    }

    // Step 3: Concrete Component
    static class EmailNotifier implements Notifier {

        public void send(String message) {
            System.out.println("Email Notification: " + message);
        }
    }

    // Step 4: Abstract Decorator
    static abstract class NotifierDecorator implements Notifier {

        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        public void send(String message) {
            notifier.send(message);
        }
    }

    // Concrete Decorator - SMS
    static class SMSNotifierDecorator extends NotifierDecorator {

        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("SMS Notification: " + message);
        }
    }

    // Concrete Decorator - Slack
    static class SlackNotifierDecorator extends NotifierDecorator {

        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Slack Notification: " + message);
        }
    }

    // Step 5: Test Decorator Pattern
    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        notifier = new SMSNotifierDecorator(notifier);

        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Server is running successfully.");
    }
}