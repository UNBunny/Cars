package com.unbunny.carweb.dto;

import com.unbunny.carweb.models.cars.Car;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
