package soloproject.demo.coffee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soloproject.demo.coffee.dto.CoffeeDto;
import soloproject.demo.coffee.entity.Coffee;
import soloproject.demo.coffee.mapper.CoffeeMapper;
import soloproject.demo.coffee.service.CoffeeService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {
  private final CoffeeService coffeeService;
  private final CoffeeMapper coffeeMapper;

  public CoffeeController(CoffeeService coffeeService, CoffeeMapper coffeeMapper) {
    this.coffeeService = coffeeService;
    this.coffeeMapper = coffeeMapper;
  }

  @PostMapping
  public ResponseEntity postCoffee(@Valid @RequestBody CoffeeDto.Post requestBody) {

    Coffee request = coffeeMapper.coffeePostDtoToCoffee(requestBody);
    Coffee coffee = coffeeService.createCoffee(request);
    CoffeeDto.Response response = coffeeMapper.coffeeToCoffeeResponseDto(coffee);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PatchMapping("/{coffee-id}")
  public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                    @Valid @RequestBody CoffeeDto.Patch requestBody) {

    requestBody.setCoffeeId(coffeeId);

    Coffee request = coffeeMapper.coffeePatchDtoToCoffee(requestBody);
    Coffee coffee = coffeeService.updateCoffee(request);
    CoffeeDto.Response response = coffeeMapper.coffeeToCoffeeResponseDto(coffee);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{coffee-id}")
  public ResponseEntity getCoffee(@PathVariable("coffee-id") @Valid long coffeeId) {

    Coffee coffee = coffeeService.findCoffee(coffeeId);
    CoffeeDto.Response response = coffeeMapper.coffeeToCoffeeResponseDto(coffee);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity getCoffees() {

    List<Coffee> coffees = coffeeService.findCoffees();
    List<CoffeeDto.Response> response = coffees.stream().map(coffee -> coffeeMapper.coffeeToCoffeeResponseDto(coffee)).collect(Collectors.toList());

    return new ResponseEntity<>(response,HttpStatus.OK);
  }

  @DeleteMapping("/{coffee-id}")
  public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Valid long coffeeId) {
    coffeeService.deleteCoffee(coffeeId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
