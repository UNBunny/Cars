package com.unbunny.carweb.dto.filters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarFilterRequest {
    private String categorySlug;
    private String manufacturerSlug;
    private Integer yearFrom;
    private Integer yearTo;
    private String sort;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}