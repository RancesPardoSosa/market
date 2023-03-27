package com.market.marketapi.mapper;

import com.market.marketapi.dto.CategoryDTO;
import com.market.marketapi.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryDTOMapper {
    CategoryDTO toCategoryDTO(Category category);
    @InheritInverseConfiguration
    @Mapping(target = "products" , ignore = true)
    Category toCategory(CategoryDTO categoryDTO);

}
