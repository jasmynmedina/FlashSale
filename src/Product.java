public class Product {
    private int id;
    private String name;
    private double price;
    private int inventory;

    public Product(int id, String name, double price, int inventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
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
