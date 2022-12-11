package soloproject.demo.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.order.dto.OrderDto;
import soloproject.demo.order.entity.Order;
import soloproject.demo.order.mapper.OrderMapper;
import soloproject.demo.order.service.OrderService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
  private final OrderService orderService;
  private final OrderMapper orderMapper;

  public OrderController(OrderService orderService, OrderMapper orderMapper) {
    this.orderService = orderService;
    this.orderMapper = orderMapper;
  }

  @PostMapping
  public ResponseEntity postOrder(@Valid @RequestBody OrderDto.Post requestBody) {

    Order request = orderMapper.orderPostDtoToOrder(requestBody);
    Order order = orderService.createOrder(request);
    OrderDto.Response response = orderMapper.orderToOrderResponseDto(order);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PatchMapping("/{order-id}")
  public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                   @Valid @RequestBody OrderDto.Patch requestBody) {

    requestBody.setOrderId(orderId);

    Order request = orderMapper.orderPatchDtoToOrder(requestBody);
    Order order = orderService.updateOrder(request);
    OrderDto.Response response = orderMapper.orderToOrderResponseDto(order);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{order-id}")
  public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {

    Order order = orderService.findOrder(orderId);
    OrderDto.Response response = orderMapper.orderToOrderResponseDto(order);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getOrders() {

    List<Order> orders = orderService.findOrders();
    List<OrderDto.Response> response = orders.stream().map(order -> orderMapper.orderToOrderResponseDto(order)).collect(Collectors.toList());

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{order-id}")
  public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId) {
    orderService.cancelOrder(orderId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
