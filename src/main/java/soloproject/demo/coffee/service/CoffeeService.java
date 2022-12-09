package soloproject.demo.coffee.service;

import soloproject.demo.coffee.entity.Coffee;

import java.util.List;

public class CoffeeService {
  public Coffee createCoffee(Coffee coffee) {
    Coffee createdCoffee = coffee;
    return createdCoffee;
  }

  public Coffee updateCoffee(Coffee coffee) {
    Coffee updatedCoffee = coffee;
    return updatedCoffee;
  }

  public Coffee findCoffee(long coffeeId) {
    Coffee coffee = new Coffee(coffeeId, "Americano", "아메리카노", 4500, "AMC");
    return coffee;
  }

  public List<Coffee> findCoffees() {
    List<Coffee> coffees = List.of(new Coffee(1, "Americano", "아메리카노", 4500, "AMC"),
                                  new Coffee(2, "Latte", "라떼", 4500, "LAT"));
    return coffees;
  }

  public void deleteCoffee(long coffeeId) {

  }
}
