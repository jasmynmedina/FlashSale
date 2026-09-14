public class Order {
    private int id;
    private Customer customer;
    private Product product;
    private double price;

    public Order(int id, Customer customer, Product product, double price) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }
}