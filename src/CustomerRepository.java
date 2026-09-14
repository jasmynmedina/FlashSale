import java.util.List;

public interface CustomerRepository {

    void save(Customer customer);

    Customer findByName(String customerName);

    List<Customer> findAll();
}