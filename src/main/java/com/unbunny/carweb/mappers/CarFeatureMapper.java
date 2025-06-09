package com.unbunny.carweb.mappers;


import com.unbunny.carweb.dto.CarFeatureDto;
import com.unbunny.carweb.models.cars.CarFeature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarFeatureMapper {
    CarFeatureDto toDto(CarFeature carFeature);
    CarFeature toEntity(CarFeatureDto carFeatureDto);
}
