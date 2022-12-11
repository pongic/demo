package soloproject.demo.coffee.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import soloproject.demo.coffee.dto.CoffeeDto;
import soloproject.demo.coffee.entity.Coffee;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
  Coffee coffeePostDtoToCoffee(CoffeeDto.Post coffeePostDto);

  Coffee coffeePatchDtoToCoffee(CoffeeDto.Patch coffeePatchDto);

  CoffeeDto.Response coffeeToCoffeeResponseDto(Coffee coffee);
}
