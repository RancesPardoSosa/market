package com.market.marketapi.dao;

import com.market.marketapi.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    List<ProductDTO> getAll();
    Optional<ProductDTO> getProduct(Integer idProduct);
    Optional<List<ProductDTO>> getByCategory(Integer idCategory);
    Boolean deleteProduct(Integer idProduct);

}
