public class Order {
    private Customer customer;
    private Product product;
    private double price;

    public Order(Customer customer, Product product, double price) {
        this.customer = customer;
        this.product = product;
        this.price = price;
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