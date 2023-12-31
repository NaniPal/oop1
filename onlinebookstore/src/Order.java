import java.time.LocalDate;
import java.util.List;
public class Order {
    private Long orderId;
    private Long customerId;
    private LocalDate orderDate;
    private String orderStatus;

    // Constructors, getters, and setters

    // Constructors
    public Order() {
    }

    public Order(Long orderId, Long customerId, LocalDate orderDate, String orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    // Getters and setters
    // You can generate these methods automatically in most IDEs.

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // toString method (optional, for debugging purposes)
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}


