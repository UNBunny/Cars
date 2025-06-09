package com.unbunny.carweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CarResponse {
    private Long id;

    private String model;

    private Integer year;

    private String mainImageUrl;

    private String description;

    private Integer views;

    private Double price;

    private ManufacturerResponse manufacturer;

    private BodyTypeDto bodyType;

    private EngineTypeDto engineType;

    private Integer powerHp;
    private Double batteryCapacityKwh;
    private Integer rangeKm;
    private Double acceleration0100;
    private Integer topSpeedKmh;

    private List<CarImageDto> imageUrls;
    private List<CarFeatureDto> features;
    private List<String> categories;
}
