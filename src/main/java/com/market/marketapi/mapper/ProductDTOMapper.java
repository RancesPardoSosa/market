package com.market.marketapi.mapper;

import com.market.marketapi.dto.ProductDTO;
import com.market.marketapi.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {CategoryDTOMapper.class})
public interface ProductDTOMapper {
    ProductDTO toProductDto (Product product);
    List<ProductDTO> toProductDtoList(List<Product> products);
    @InheritInverseConfiguration
    @Mapping(target = "barcode" , ignore = true)
    Product toProduct(ProductDTO productDTO);
}
