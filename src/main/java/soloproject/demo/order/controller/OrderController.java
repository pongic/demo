package soloproject.demo.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.order.dto.OrderDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
  @PostMapping
  public ResponseEntity postOrder(@Valid @RequestBody OrderDto.Post requestBody) {

    return new ResponseEntity<>(requestBody, HttpStatus.CREATED);
  }

  @PatchMapping("/{order-id}")
  public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                   @Valid @RequestBody OrderDto.Patch requestBody) {

    requestBody.setOrderId(orderId);

    return new ResponseEntity<>(requestBody, HttpStatus.OK);
  }

  @GetMapping("/{order-id}")
  public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
    System.out.println("# orderId: " + orderId);


    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getOrders() {
    System.out.println("# get Orders");


    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{order-id}")
  public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
