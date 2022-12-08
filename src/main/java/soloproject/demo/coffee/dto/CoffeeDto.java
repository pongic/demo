package soloproject.demo.coffee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;


public class CoffeeDto {
  @Getter
  public static class Post {
    @NotBlank
    private String korName;

    @NotBlank
    private String engName;

    @Range(min = 100, max = 50000)
    private int price;

    @NotBlank
    private String coffeeCode;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  public static class Patch {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
  }

  @AllArgsConstructor
  @Getter
  public static class Response {
    private long coffeeId;
    private String coffeeCode;
    private String korName;
    private String engName;
    private int price;
  }
}