import java.util.List;

public interface ProductRepository {

    void save(Product product);

    Product findByName(String searchName);

    List<Product> findAll();
}