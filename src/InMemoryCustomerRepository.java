import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository implements CustomerRepository {
    private ArrayList<Customer> customers;

    public InMemoryCustomerRepository() {
        this.customers = new ArrayList<>();
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findByName(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}