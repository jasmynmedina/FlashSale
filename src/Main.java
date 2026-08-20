public class Main {
    public static void main(String[] args) {
        Product product = new Product("Planner Notebook", 39.99, 3);

        System.out.println("FLASHSALE");
        System.out.println("------------------------------");
        System.out.println("Product: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Starting Inventory: " + product.getInventory());

        System.out.println();

        boolean successful = product.purchase();
        if (successful) {
            System.out.println("Customer 1: PURCHASE SUCCESSFUL");
        } else {
            System.out.println("Customer 1: SOLD OUT");
        }
        System.out.println("Remaining Inventory: " + product.getInventory());

        System.out.println();
        successful = product.purchase();
        if (successful) {
            System.out.println("Customer 2: PURCHASE SUCCESSFUL");
        } else {
            System.out.println("Customer 2: SOLD OUT");
        }
        System.out.println("Remaining Inventory: " + product.getInventory());
        System.out.println();

        successful = product.purchase();
        if (successful) {
            System.out.println("Customer 3: PURCHASE SUCCESSFUL");
        } else {
            System.out.println("Customer 3: SOLD OUT");
        }
        System.out.println("Remaining Inventory: " + product.getInventory());
        System.out.println();

        successful = product.purchase();
        if (successful) {
            System.out.println("Customer 4: PURCHASE SUCCESSFUL");
        } else {
            System.out.println("Customer 4: SOLD OUT");
        }
        System.out.println("Remaining Inventory: " + product.getInventory());
    }
}