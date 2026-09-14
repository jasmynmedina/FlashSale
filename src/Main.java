import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FlashSaleService flashSale = new FlashSaleService();

        Product product1 = new Product("Planner Notebook", 39.99, 3);
        Product product2 = new Product("Scrapbook", 30.99, 4);
        Product product3 = new Product("Ribbon", 12.50, 3);

        flashSale.addProduct(product1);
        flashSale.addProduct(product2);
        flashSale.addProduct(product3);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========== FLASHSALE ==========");
            System.out.println();

            System.out.println("----PRODUCTS AVAILABLE----");

            for (Product item : flashSale.getProducts()) {
                System.out.println("Product: " + item.getName());
                System.out.println("Price: $" + item.getPrice());
                System.out.println("Inventory: " + item.getInventory());
                System.out.println();
            }

            System.out.println("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            Customer customer = flashSale.findCustomer(customerName);

            if (customer == null) {
                customer = new Customer(customerName);
                flashSale.addCustomer(customer);
            }

            System.out.println("Welcome " + customer.getName() + "!");
            System.out.println();

            System.out.println("Enter Product Name: ");
            String searchName = scanner.nextLine();

            Product selectedProduct = flashSale.findProduct(searchName);

            if (selectedProduct != null) {

                System.out.println();
                System.out.println("Selected Product: " + selectedProduct.getName());
                System.out.println("Price: $" + selectedProduct.getPrice());
                System.out.println("Inventory: " + selectedProduct.getInventory());
                System.out.println();

                flashSale.attemptPurchase(customer, selectedProduct);

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

        for (Order order : flashSale.getOrders()) {
            System.out.println(
                    order.getCustomer().getName()
                            + " purchased "
                            + order.getProduct().getName()
                            + " for $"
                            + order.getPrice()
            );
        }

        System.out.println();
        System.out.println("Total Orders: " + flashSale.getOrders().size());

        scanner.close();
    }
}