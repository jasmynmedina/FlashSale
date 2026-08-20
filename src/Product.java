public class Product {
    private String name;
    private double price;
    private int inventory;

    public Product(String name, double price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getInventory() {
        return inventory;
    }

    public boolean purchase() {
        if(inventory > 0) {
            inventory--;
            return true;
        } else {
            return false;
        }
    }
}
