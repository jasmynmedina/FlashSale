import java.util.ArrayList;
import java.util.List;

public class InMemoryProductRepository implements ProductRepository {
    private ArrayList<Product> products;

    public InMemoryProductRepository() {
        this.products = new ArrayList<>();
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findByName(String searchName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchName)) {
                return product;
            }
        }
        return null;
    }
}