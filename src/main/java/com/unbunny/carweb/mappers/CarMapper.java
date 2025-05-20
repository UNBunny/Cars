package com.unbunny.carweb.mappers;

import com.unbunny.carweb.dto.BodyTypeDto;
import com.unbunny.carweb.dto.CarFeatureDto;
import com.unbunny.carweb.dto.CarImageDto;
import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.dto.EngineTypeDto;
import com.unbunny.carweb.dto.ManufacturerResponse;
import com.unbunny.carweb.models.cars.BodyType;
import com.unbunny.carweb.models.cars.Car;
import com.unbunny.carweb.models.cars.CarFeature;
import com.unbunny.carweb.models.cars.CarImage;
import com.unbunny.carweb.models.cars.Category;
import com.unbunny.carweb.models.cars.EngineType;
import com.unbunny.carweb.models.cars.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "imageUrls", source = "images", qualifiedByName = "mapImagesToDtos")
    @Mapping(target = "mainImageUrl", source = "images", qualifiedByName = "mapMainImageUrl")
    @Mapping(target = "categories", source = "categories", qualifiedByName = "mapCategoriesToStrings")
    CarResponse toCarResponse(Car car);

    ManufacturerResponse toManufacturerResponse(Manufacturer manufacturer);

    BodyTypeDto toBodyTypeDto(BodyType bodyType);

    EngineTypeDto toEngineTypeDto(EngineType engineType);

    CarFeatureDto toCarFeatureDto(CarFeature carFeature);

    @Named("mapImagesToDtos")
    default List<CarImageDto> mapImagesToDtos(List<CarImage> images) {
        if (images == null) {
            return List.of();
        }
        return images.stream()
                .map(this::toCarImageDto)
                .collect(Collectors.toList());
    }

    @Named("mapMainImageUrl")
    default String mapMainImageUrl(List<CarImage> images) {
        if (images == null) {
            return null;
        }
        return images.stream()
                .filter(CarImage::getIsMain)
                .findFirst()
                .map(CarImage::getImageUrl)
                .orElse(null);
    }

    default CarImageDto toCarImageDto(CarImage image) {
        return CarImageDto.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .isMain(image.getIsMain())
                .altText(image.getAltText())
                .build();
    }

    default List<String> mapCategories(Set<Category> categories) {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
    @Named("mapCategoriesToStrings")
    default List<String> mapCategoriesToStrings(List<Category> categories) {
        if (categories == null) {
            return Collections.emptyList();
        }
        return categories.stream()
                .map(Category::getSlug) // или другой метод, например getName()
                .collect(Collectors.toList());
    }

}
