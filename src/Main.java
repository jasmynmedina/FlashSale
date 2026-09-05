import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        Product product1 = new Product("Planner Notebook", 39.99, 3);
        Product product2 = new Product("Scrapbook", 30.99, 4);
        Product product3 = new Product("Ribbon", 12.50, 3);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========== FLASHSALE ==========");
            System.out.println();

            System.out.println("----PRODUCTS AVAILABLE----");

            for (Product item : products) {
                System.out.println("Product: " + item.getName());
                System.out.println("Price: $" + item.getPrice());
                System.out.println("Inventory: " + item.getInventory());
                System.out.println();
            }

            System.out.println("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            Customer customer = findCustomer(customers, customerName);

            if (customer == null) {
                customer = new Customer(customerName);
                customers.add(customer);
            }

            System.out.println("Welcome " + customer.getName() + "!");
            System.out.println();

            System.out.println("Enter Product Name: ");
            String searchName = scanner.nextLine();

            Product selectedProduct = findProduct(products, searchName);

            if (selectedProduct != null) {

                System.out.println();
                System.out.println("Selected Product: " + selectedProduct.getName());
                System.out.println("Price: $" + selectedProduct.getPrice());
                System.out.println("Inventory: " + selectedProduct.getInventory());
                System.out.println();

                Order order = attemptPurchase(customer, selectedProduct);

                if (order != null) {
                    orders.add(order);
                }

                System.out.println(
                        "Remaining Inventory: "
                                + selectedProduct.getInventory()
                );

            } else {
                System.out.println("Product not found.");
            }

            System.out.println();
            System.out.println("Would you like another customer to shop? yes/no");
            String continueShopping = scanner.nextLine();

            if (continueShopping.equalsIgnoreCase("no")) {
                running = false;
            }
        }

        System.out.println();
        System.out.println("========== ORDER SUMMARY ==========");

        for (Order order : orders) {
            System.out.println(
                    order.getCustomer().getName()
                            + " purchased "
                            + order.getProduct().getName()
                            + " for $"
                            + order.getPrice()
            );
        }

        System.out.println();
        System.out.println("Total Orders: " + orders.size());

        scanner.close();
    }

    public static Product findProduct(
            ArrayList<Product> products,
            String searchName) {

        for (Product item : products) {

            if (item.getName().equalsIgnoreCase(searchName)) {
                return item;
            }
        }

        return null;
    }

    public static Customer findCustomer(
            ArrayList<Customer> customers,
            String customerName) {

        for (Customer customer : customers) {

            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }

        return null;
    }

    public static Order attemptPurchase(
            Customer customer,
            Product product) {

        if (customer.hasPurchased()) {

            System.out.println(
                    "----PURCHASE DENIED - LIMIT REACHED----"
            );

            return null;
        }

        boolean successful = product.purchase();

        if (successful) {

            customer.markPurchased();

            System.out.println(
                    "----PURCHASE SUCCESSFUL----"
            );

            return new Order(
                    customer,
                    product,
                    product.getPrice()
            );

        } else {

            System.out.println(
                    "----SOLD OUT----"
            );

            return null;
        }
    }
}