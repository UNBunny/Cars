package com.unbunny.carweb.mappers;


import com.unbunny.carweb.dto.CarImageDto;
import com.unbunny.carweb.models.cars.CarImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarImageMapper {
    CarImageDto toDto(CarImage carImage);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car", ignore = true)
    CarImage toEntity(CarImageDto carImageDto);
}
