package com.unbunny.carweb.mappers;


import com.unbunny.carweb.dto.EngineTypeDto;
import com.unbunny.carweb.models.cars.BodyType;
import com.unbunny.carweb.models.cars.EngineType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EngineTypeMapper {
    EngineTypeDto toDto(EngineType engineType);

    default EngineType idToEngineType(Long id) {
        EngineType engineType = new EngineType();
        engineType.setId(id);
        return engineType;
    }
}
