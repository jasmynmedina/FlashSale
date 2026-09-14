import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {
    private ArrayList<Order> orders;

    public InMemoryOrderRepository() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public boolean existsByCustomerAndProduct(Customer customer, Product product) {
        for (Order order : orders) {
            if (order.getCustomer().getId() == customer.getId()
                    && order.getProduct().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }
}