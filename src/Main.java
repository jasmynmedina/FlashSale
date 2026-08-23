import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        Product product1 = new Product("Planner Notebook", 39.99, 3);
        Product product2 = new Product("Scrapbook", 30.99, 4);
        Product product3 = new Product("Ribbon", 12.50, 0);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        System.out.println("----PRODUCTS AVAILABLE----");
        for (Product item : products) {
            System.out.println("Product: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println("Inventory: " + item.getInventory());
            System.out.println();
        }

        String searchName = "Ribbon";
        Product selectedProduct = findProduct(products, searchName);
        Customer customer = new Customer("Jasmyn");
        System.out.println("----CUSTOMER ATTEMPTS PURCHASE----");
        if (selectedProduct != null) {
            System.out.println("Selected Product: " + selectedProduct.getName());
            System.out.println("Price: $" + selectedProduct.getPrice());
            System.out.println("Inventory: " + selectedProduct.getInventory());
            System.out.println();
            attemptPurchase(customer, selectedProduct);
            System.out.println("Remaining Inventory: " + selectedProduct.getInventory());
            System.out.println();
            System.out.println("----CUSTOMER ATTEMPTS ANOTHER PURCHASE----");
            attemptPurchase(customer, selectedProduct);
            System.out.println("Remaining Inventory: " + selectedProduct.getInventory());
        } else {
            System.out.println("Product not found");
        }
    }
    public static Product findProduct(ArrayList<Product> products, String searchName) {
        for (Product item : products) {
            if (item.getName().equals(searchName)) {
                return item;
            }
        }
        return null;
    }
    public static void attemptPurchase(Customer customer, Product product) {
        if (!customer.hasPurchased()) {
            boolean successful = product.purchase();
            if (successful) {
                customer.markPurchased();
                System.out.println("----PURCHASE SUCCESSFUL----");
            } else {
                System.out.println("----SOLD OUT----");
            }
        } else {
            System.out.println("----PURCHASE DENIED - LIMIT REACHED----");
        }
    }
}