package soloproject.demo.order.service;

import org.springframework.stereotype.Service;
import soloproject.demo.order.entity.Order;

import java.util.List;
@Service
public class OrderService {
  public Order createOrder(Order order) {
    Order createdOrder = order;
    return createdOrder;
  }

  public Order updateOrder(Order order) {
    Order updatedOrder = order;
    return updatedOrder;
  }

  public Order findOrder(long orderId) {
    Order order = new Order(orderId);
    return order;
  }

  public List<Order> findOrders() {
    List<Order> orders = List.of(new Order(1),
                                new Order(2));
    return orders;
  }

  public void cancelOrder(long orderId) {
  }
}