package com.unbunny.carweb.mappers;


import com.unbunny.carweb.dto.CarFeatureDto;
import com.unbunny.carweb.models.cars.CarFeature;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarFeatureMapper {
    CarFeatureDto toDto(CarFeature carFeature);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car", ignore = true)
    CarFeature toEntity(CarFeatureDto carFeatureDto);
}
