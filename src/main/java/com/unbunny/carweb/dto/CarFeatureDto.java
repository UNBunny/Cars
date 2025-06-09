package com.unbunny.carweb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarFeatureDto {
    private String featureName;
    private String featureValue;
}
