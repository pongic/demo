package soloproject.demo.coffee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.coffee.dto.CoffeeDto;
import soloproject.demo.coffee.entity.Coffee;
import soloproject.demo.coffee.service.CoffeeService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {
  private final CoffeeService coffeeService;

  public CoffeeController(CoffeeService coffeeService) {
    this.coffeeService = coffeeService;
  }

  @PostMapping
  public ResponseEntity postCoffee(@Valid @RequestBody CoffeeDto.Post requestBody) {

    Coffee coffee = new Coffee();
    coffee.setEngName(requestBody.getEngName());
    coffee.setKorName(requestBody.getKorName());
    coffee.setPrice(requestBody.getPrice());
    coffee.setCoffeeCode(requestBody.getCoffeeCode());

    Coffee response = coffeeService.createCoffee(coffee);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PatchMapping("/{coffee-id}")
  public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                    @Valid @RequestBody CoffeeDto.Patch requestBody) {

    requestBody.setCoffeeId(coffeeId);
    requestBody.setKorName("아메리카노");

    return new ResponseEntity<>(requestBody, HttpStatus.OK);
  }

  @GetMapping("/{coffee-id}")
  public ResponseEntity getCoffee(@PathVariable("coffee-id") @Valid long coffeeId) {
    System.out.println("#coffeeId: " + coffeeId);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getCoffees() {
    System.out.println("# get Members");

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{coffee-id}")
  public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Valid long coffeeId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
