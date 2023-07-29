import java.util.List;

public interface OrderRepository {
    Order save(OrderDTO order);

    Order findById(Long orderId);

    List<Order> findAll();

    void deleteById(Long orderId);
}


