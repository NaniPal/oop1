
import java.util.List;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Method to handle HTTP GET request to get all orders
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Method to handle HTTP GET request to get order by ID
    public OrderDTO getOrderById(Long orderId) {
        return orderService.getOrderById(orderId);
    }

    // Method to handle HTTP POST request to add a new order
    public OrderDTO addOrder(OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    // Method to handle HTTP PUT request to update an existing order
    public OrderDTO updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        return orderService.updateOrder(orderId, updatedOrderDTO);
    }

    // Method to handle HTTP DELETE request to delete an order
    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
