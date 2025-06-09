package com.unbunny.carweb.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CarRequest {

    @NotNull
    private Long manufacturerId;

    @NotBlank
    private String model;

    @NotNull
    @Min(1900)
    private Integer year;

    private Long bodyTypeId;
    private Long engineTypeId;
    private Integer powerHp;
    private Double batteryCapacityKwh;
    private Integer rangeKm;

    @Column(name = "acceleration_0_100")
    private Double acceleration0100;
    private Integer topSpeedKmh;

    @NotNull
    @Positive
    private Double price;

    private String mainImageUrl;
    private String description;

    @NotBlank
    private String slug;

    private List<Long> categoryIds;
    private List<CarImageDto> images;
    private List<CarFeatureDto> features;
}