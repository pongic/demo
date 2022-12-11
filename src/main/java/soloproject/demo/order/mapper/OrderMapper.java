package soloproject.demo.order.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import soloproject.demo.order.dto.OrderDto;
import soloproject.demo.order.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
  Order orderPostDtoToOrder(OrderDto.Post orderPostDto);

  Order orderPatchDtoToOrder(OrderDto.Patch orderPatchDto);

  OrderDto.Response orderToOrderResponseDto(Order order);
}
