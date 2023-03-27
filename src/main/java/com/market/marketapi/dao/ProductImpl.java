package com.market.marketapi.dao;

import com.market.marketapi.crud.ProductCrudDAO;
import com.market.marketapi.dto.ProductDTO;
import com.market.marketapi.entity.Product;
import com.market.marketapi.mapper.ProductDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductImpl implements ProductDAO{
    @Autowired
    private ProductCrudDAO productCrudDAO;
    @Autowired
    private ProductDTOMapper mapper;
    @Override
    public List<ProductDTO> getAll() {
        List<Product> productos = (List<Product>)productCrudDAO.findAll();
        return mapper.toProductDtoList(productos);
    }

    @Override
    public Optional<ProductDTO> getProduct(Integer idProduct) {
        return productCrudDAO.findById(idProduct)
                .map(product -> mapper.toProductDto(product));
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(Integer idCategory) {
        return productCrudDAO.findByIdCategory(idCategory)
                .map(products -> mapper.toProductDtoList(products));
    }
}
