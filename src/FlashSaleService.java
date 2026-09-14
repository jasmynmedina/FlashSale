import java.util.List;

public class FlashSaleService {
    private int nextOrderId;
    private int nextCustomerId;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    public FlashSaleService(ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.nextOrderId = 1;
        this.nextCustomerId = 1;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Product findProduct(String searchName) {
        return productRepository.findByName(searchName);
    }

    public Customer findCustomer(String customerName) {
        return customerRepository.findByName(customerName);
    }

    public PurchaseStatus attemptPurchase(Customer customer, Product product) {
        if (hasPurchasedProduct(customer, product)) {
            return PurchaseStatus.LIMIT_REACHED;
        }

        boolean successful = product.purchase();

        if (successful) {
            Order order = new Order(nextOrderId, customer, product, product.getPrice());
            nextOrderId++;
            orderRepository.save(order);
            return PurchaseStatus.SUCCESS;
        }
        else {
            return PurchaseStatus.SOLD_OUT;
        }
    }

    public boolean hasPurchasedProduct(Customer customer, Product product) {
        return orderRepository.existsByCustomerAndProduct(customer, product);
    }

    public Customer createCustomer(String customerName) {
        Customer customer = new Customer(nextCustomerId, customerName);
        nextCustomerId++;
        customerRepository.save(customer);
        return customer;
    }
}
