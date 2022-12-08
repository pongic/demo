package soloproject.demo.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class OrderDto {
  @Getter
  public static class Post {
    private long memberId;
  }

  @Getter
  @Setter
  public static class Patch {
    private long orderId;
  }

  @Getter
  @Setter
  private static class Response {
    private long orderId;
    private long memberId;
  }
}
