import java.util.Scanner;

class Food {
    int id;
    String name;
    double price;

    Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order {
    int orderId;
    String itemName;
    double price;
    int quantity;

    Order(int orderId, String itemName, double price, int quantity) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

public class FoodMenuSystem {

    static Food[] menu = new Food[10];
    static Order[] orders = new Order[20];
    static int menuCount = 0;
    static int orderCount = 0;
    static int orderIdCounter = 1;

    static Scanner scanner = new Scanner(System.in);

    // Load menu
    public static void loadMenu() {
        menu[menuCount++] = new Food(1, "Cheeseburger", 5.99);
        menu[menuCount++] = new Food(2, "Fries", 2.99);
        menu[menuCount++] = new Food(3, "Pizza", 3.49);
        menu[menuCount++] = new Food(4, "Nachos", 4.49);
        menu[menuCount++] = new Food(5, "Drink", 1.99);
    }

    // Display menu
    public static void displayMenu() {
        System.out.println("\n🍽️ MENU");
        for (int i = 0; i < menuCount; i++) {
            System.out.println(menu[i].id + " - " + menu[i].name + " - $" + menu[i].price);
        }
    }

    // Add order
    public static void addOrder() {
        displayMenu();

        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();

        for (int i = 0; i < menuCount; i++) {
            if (menu[i].id == id) {
                orders[orderCount++] = new Order(
                        orderIdCounter++,
                        menu[i].name,
                        menu[i].price,
                        qty
                );
                System.out.println("✅ Added to order!");
                return;
            }
        }

        System.out.println("❌ Item not found.");
    }

    // View orders
    public static void viewOrders() {
        System.out.println("\n🧾 CURRENT ORDERS");

        if (orderCount == 0) {
            System.out.println("No orders yet.");
            return;
        }

        for (int i = 0; i < orderCount; i++) {
            double subtotal = orders[i].price * orders[i].quantity;

            System.out.println("Order #" + orders[i].orderId +
                    " | " + orders[i].itemName +
                    " x" + orders[i].quantity +
                    " | $" + subtotal);
        }
    }

    // Checkout
    public static void checkout() {
        if (orderCount == 0) {
            System.out.println("❌ No items to checkout.");
            return;
        }

        System.out.println("\n=========== RECEIPT ===========");
        double total = 0;

        for (int i = 0; i < orderCount; i++) {
            double subtotal = orders[i].price * orders[i].quantity;

            System.out.println(orders[i].itemName +
                    " x" + orders[i].quantity +
                    " - $" + subtotal);

            total += subtotal;
        }

        System.out.println("--------------------------------");
        System.out.println("TOTAL: $" + total);
        System.out.println("Thank you for your order!");
        System.out.println("================================");

        orderCount = 0; // clear orders
    }

    // Menu system
    public static void menuSystem() {
        System.out.println("\n===== FOOD MENU SYSTEM =====");
        System.out.println("1. View Menu");
        System.out.println("2. Add Order");
        System.out.println("3. View Orders");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {

        loadMenu();

        while (true) {
            menuSystem();
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> displayMenu();
                case 2 -> addOrder();
                case 3 -> viewOrders();
                case 4 -> checkout();
                case 5 -> {
                    System.out.println("👋 Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
