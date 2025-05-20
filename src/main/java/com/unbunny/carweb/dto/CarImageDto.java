package com.unbunny.carweb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarImageDto {
    private Long id;
    private String imageUrl;
    private Boolean isMain;
    private String altText;
}
