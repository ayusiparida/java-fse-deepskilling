import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: " + price;
    }
}

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public static void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);

        if (product != null) {
            product.quantity = quantity;
            product.price = price;
        }
    }

    public static void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public static void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

        addProduct(new Product(101, "Laptop", 10, 50000));
        addProduct(new Product(102, "Mouse", 50, 500));

        System.out.println("Initial Inventory:");
        displayProducts();

        updateProduct(101, 15, 52000);
        deleteProduct(102);

        System.out.println("\nUpdated Inventory:");
        displayProducts();
    }
}