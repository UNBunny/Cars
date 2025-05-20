package com.unbunny.carweb.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BodyTypeDto {
    private Long id;
    private String name;
}
