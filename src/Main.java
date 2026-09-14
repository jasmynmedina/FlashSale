import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductRepository productRepository = new InMemoryProductRepository();
        CustomerRepository customerRepository = new InMemoryCustomerRepository();
        OrderRepository orderRepository = new InMemoryOrderRepository();
        FlashSaleService flashSale = new FlashSaleService(productRepository, customerRepository, orderRepository);

        Product product1 = new Product(1, "Planner Notebook", 39.99, 3);
        Product product2 = new Product(2, "Scrapbook", 30.99, 4);
        Product product3 = new Product(3, "Ribbon", 12.50, 3);

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
                customer = flashSale.createCustomer(customerName);
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

                PurchaseStatus status = flashSale.attemptPurchase(customer, selectedProduct);

                if (status == PurchaseStatus.SUCCESS) {
                    System.out.println("----PURCHASE SUCCESSFUL----");
                } else if (status == PurchaseStatus.SOLD_OUT) {
                    System.out.println("----SOLD OUT----");
                } else if (status == PurchaseStatus.LIMIT_REACHED) {
                    System.out.println("----PURCHASE DENIED - PRODUCT LIMIT REACHED----");
                }

                System.out.println("Remaining Inventory: " + selectedProduct.getInventory());
            }
            else {
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