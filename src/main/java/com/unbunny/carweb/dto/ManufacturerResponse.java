package com.unbunny.carweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ManufacturerResponse {
    private Long id;
    private String name;
    private String logoUrl;
    private String description;
    private Integer foundedYear;
    private String country;
}
