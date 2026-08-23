public class Customer {
    private String name;
    private boolean hasPurchased;

    public Customer(String name) {
        this.name = name;
        this.hasPurchased = false;
    }

    public String getName() {
        return name;
    }

    public boolean hasPurchased() {
        return hasPurchased;
    }

    public void markPurchased() {
        this.hasPurchased = true;
    }
}
