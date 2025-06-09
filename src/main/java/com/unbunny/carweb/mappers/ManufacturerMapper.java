package com.unbunny.carweb.mappers;


import com.unbunny.carweb.dto.ManufacturerResponse;
import com.unbunny.carweb.models.cars.Manufacturer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    ManufacturerResponse toResponse(Manufacturer manufacturer);

    default Manufacturer idToManufacturer(Long id) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        return manufacturer;
    }
}
