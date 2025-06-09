package com.unbunny.carweb.mappers;

import com.unbunny.carweb.models.cars.Category;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    default String toSlug(Category category) {
        return category == null ? null : category.getSlug();
    }

    default Category idToCategory(Long id) {
        if (id == null) return null;
        Category category = new Category();
        category.setId(id);
        return category;
    }

    default List<Category> idsToCategories(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(this::idToCategory).collect(Collectors.toList());
    }
}
