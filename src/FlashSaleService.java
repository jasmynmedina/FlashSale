import java.util.ArrayList;

public class FlashSaleService {
    private int nextOrderId;
    private int nextCustomerId;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;

    public FlashSaleService() {
        this.nextOrderId = 1;
        this.nextCustomerId = 1;
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

    public PurchaseStatus attemptPurchase(Customer customer, Product product) {
        if (hasPurchasedProduct(customer, product)) {
            return PurchaseStatus.LIMIT_REACHED;
        }

        boolean successful = product.purchase();

        if (successful) {
            Order order = new Order(nextOrderId, customer, product, product.getPrice());
            nextOrderId++;
            orders.add(order);
            return PurchaseStatus.SUCCESS;
        }
        else {
            return PurchaseStatus.SOLD_OUT;
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public boolean hasPurchasedProduct(Customer customer, Product product) {
        for (Order order : orders) {
            if (order.getCustomer().getId() == customer.getId()
                    && order.getProduct().getId() == product.getId()) {
                return true;
            }
        }

        return false;
    }

    public Customer createCustomer(String customerName) {
        Customer customer = new Customer(nextCustomerId, customerName);
        nextCustomerId++;
        customers.add(customer);
        return customer;
    }
}
