import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcOrderRepository implements OrderRepository {
    private final Map<Long, Order> ordersMap = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Order save(OrderDTO order) {
        if (order.getOrderId() == null) {
            order.setOrderId(nextId);
            nextId++;
        }
        ordersMap.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public Order findById(Long orderId) {
        return ordersMap.get(orderId);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(ordersMap.values());
    }

    @Override
    public void deleteById(Long orderId) {
        ordersMap.remove(orderId);
    }
}
