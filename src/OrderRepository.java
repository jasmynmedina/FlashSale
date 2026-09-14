import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();

    boolean existsByCustomerAndProduct(
            Customer customer,
            Product product
    );
}