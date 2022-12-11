package soloproject.demo.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class OrderDto {
  @Getter
  public static class Post {
    private long orderId;
  }

  @Getter
  @Setter
  public static class Patch {
    private long orderId;
  }

  @Getter
  @AllArgsConstructor
  public static class Response {
    private long orderId;
    private long memberId;
  }
}
