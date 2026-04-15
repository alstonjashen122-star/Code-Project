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

    Order(int orderId, String itemName, double price) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.price = price;
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