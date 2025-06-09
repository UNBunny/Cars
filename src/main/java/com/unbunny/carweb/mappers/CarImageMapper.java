package com.unbunny.carweb.mappers;


import com.unbunny.carweb.dto.CarImageDto;
import com.unbunny.carweb.models.cars.CarImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarImageMapper {
    CarImageDto toDto(CarImage carImage);
}
