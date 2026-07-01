public class ProxyPatternExample {

    // Step 2: Subject Interface
    interface Image {
        void display();
    }

    // Step 3: Real Subject
    static class RealImage implements Image {

        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading " + fileName + " from remote server...");
        }

        public void display() {
            System.out.println("Displaying " + fileName);
        }
    }

    // Step 4: Proxy Class
    static class ProxyImage implements Image {

        private String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        public void display() {

            // Lazy Initialization + Caching
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }

            realImage.display();
        }
    }

    // Step 5: Test Proxy Pattern
    public static void main(String[] args) {

        Image image = new ProxyImage("nature.jpg");

        System.out.println("First Display:");
        image.display();

        System.out.println();

        System.out.println("Second Display:");
        image.display();
    }
}