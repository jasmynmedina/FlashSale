import java.util.ArrayList;

public class FlashSaleService {
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;

    public FlashSaleService() {
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product findProduct(String searchName) {
        for (Product item : products) {
            if (item.getName().equalsIgnoreCase(searchName)) {
                return item;
            }
        }
        return null;
    }

    public Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }

        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Order attemptPurchase(Customer customer, Product product) {
        if (customer.hasPurchased()) {
            System.out.println("----PURCHASE DENIED - LIMIT REACHED----");
            return null;
        }

        boolean successful = product.purchase();

        if (successful) {
            customer.markPurchased();
            Order order = new Order(customer, product, product.getPrice());
            orders.add(order);
            System.out.println("----PURCHASE SUCCESSFUL----");
            return order;
        }
        else {
            System.out.println("----SOLD OUT----");
            return null;
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
