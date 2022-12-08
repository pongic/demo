package soloproject.demo.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
  private long coffeeId;
  private String engName;
  private String korName;
  private int price;
  private String coffeeCode;
}
