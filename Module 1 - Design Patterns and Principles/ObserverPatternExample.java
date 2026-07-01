import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    // Step 4: Observer Interface
    interface Observer {
        void update(String stockName, double price);
    }

    // Step 2: Subject Interface
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    // Step 3: Concrete Subject
    static class StockMarket implements Stock {

        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double price;

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, price);
            }
        }

        public void setStockPrice(String stockName, double price) {
            this.stockName = stockName;
            this.price = price;
            notifyObservers();
        }
    }

    // Step 5: Concrete Observer
    static class MobileApp implements Observer {

        public void update(String stockName, double price) {
            System.out.println("Mobile App: " + stockName +
                    " price updated to Rs." + price);
        }
    }

    // Step 5: Concrete Observer
    static class WebApp implements Observer {

        public void update(String stockName, double price) {
            System.out.println("Web App: " + stockName +
                    " price updated to Rs." + price);
        }
    }

    // Step 6: Test Observer Pattern
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice("TCS", 4200);

        System.out.println();

        stockMarket.setStockPrice("Infosys", 1650);
    }
}