package com.unbunny.carweb.mappers;

import com.unbunny.carweb.dto.BodyTypeDto;
import com.unbunny.carweb.models.cars.BodyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BodyTypeMapper {
    BodyTypeDto toDto(BodyType bodyType);

    default BodyType idToBodyType(Long id) {
        BodyType bodyType = new BodyType();
        bodyType.setId(id);
        return bodyType;
    }
}
