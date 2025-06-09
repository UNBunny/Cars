package com.unbunny.carweb.mappers;

import com.unbunny.carweb.dto.CarRequest;
import com.unbunny.carweb.dto.CarResponse;
import com.unbunny.carweb.models.cars.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


// Нужно полностью переписать Mapper (ПОЛНОСТЬЮ!!!!!!)
@Mapper(componentModel = "spring", uses = {ManufacturerMapper.class, BodyTypeMapper.class, EngineTypeMapper.class, CarImageMapper.class, CategoryMapper.class, CarFeatureMapper.class})
public interface CarMapper {

    // === CarRequest -> Car ===

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "manufacturer", source = "manufacturerId") // +
    @Mapping(target = "bodyType", source = "bodyTypeId") // +
    @Mapping(target = "engineType", source = "engineTypeId") //  +
    @Mapping(target = "images", source = "images") // +-
    @Mapping(target = "features", source = "features") // +-
    @Mapping(target = "categories", source = "categoryIds")
    @Mapping(target = "views", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Car toCar(CarRequest carRequest);

    // === Car -> CarResponse ===

    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "bodyType", source = "bodyType")
    @Mapping(target = "engineType", source = "engineType")
    @Mapping(target = "imageUrls", source = "images")
    @Mapping(target = "mainImageUrl", source = "mainImageUrl")
    @Mapping(target = "categories", source = "categories")
    CarResponse toCarResponse(Car car);

//    // === DTO -> Entity коллекции ===
//
//    @Named("mapImages")
//    default List<CarImage> mapImages(List<CarImageDto> dtos, @Context Car car) {
//        if (dtos == null) return Collections.emptyList();
//        return dtos.stream()
//                .map(dto -> CarImage.builder()
//                        .imageUrl(dto.getImageUrl())
//                        .isMain(dto.getIsMain())
//                        .altText(dto.getAltText())
//                        .car(car)
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    @Named("mapFeatures")
//    default List<CarFeature> mapFeatures(List<CarFeatureDto> dtos, @Context Car car) {
//        if (dtos == null) return Collections.emptyList();
//        return dtos.stream()
//                .map(dto -> CarFeature.builder()
//                        .featureName(dto.getFeatureName())
//                        .featureValue(dto.getFeatureValue())
//                        .car(car)
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    @Named("mapCategories")
//    default List<Category> mapCategories(List<Long> categoryIds) {
//        if (categoryIds == null) return Collections.emptyList();
//        return categoryIds.stream()
//                .map(id -> Category.builder().id(id).build())
//                .collect(Collectors.toList());
//    }
//
//    // === Entity -> DTO методы ===
//
//
//    @Named("toBodyTypeDto")
//    default BodyTypeDto toBodyTypeDto(BodyType bodyType) {
//        if (bodyType == null) return null;
//        return BodyTypeDto.builder()
//                .id(bodyType.getId())
//                .name(bodyType.getName())
//                .build();
//    }
//
//    @Named("toEngineTypeDto")
//    default EngineTypeDto toEngineTypeDto(EngineType engineType) {
//        if (engineType == null) return null;
//        return EngineTypeDto.builder()
//                .id(engineType.getId())
//                .name(engineType.getName())
//                .build();
//    }
//
//    // === Коллекции изображений, категорий и т.д. ===
//
//    @Named("mapImagesToDtos")
//    default List<CarImageDto> mapImagesToDtos(List<CarImage> images) {
//        if (images == null) return Collections.emptyList();
//        return images.stream()
//                .map(image -> CarImageDto.builder()
//                        .id(image.getId())
//                        .imageUrl(image.getImageUrl())
//                        .isMain(image.getIsMain())
//                        .altText(image.getAltText())
//                        .build())
//                .collect(Collectors.toList());
//    }
//
//    @Named("mapMainImageUrl")
//    default String mapMainImageUrl(List<CarImage> images) {
//        return images == null ? null :
//                images.stream()
//                        .filter(CarImage::getIsMain)
//                        .findFirst()
//                        .map(CarImage::getImageUrl)
//                        .orElse(null);
//    }
//
//    @Named("mapCategoriesToStrings")
//    default List<String> mapCategoriesToStrings(List<Category> categories) {
//        if (categories == null) return Collections.emptyList();
//        return categories.stream()
//                .map(Category::getName) // или getSlug(), в зависимости от того, что нужно
//                .collect(Collectors.toList());
//    }


}