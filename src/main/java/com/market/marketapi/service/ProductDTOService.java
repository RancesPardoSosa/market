package com.market.marketapi.service;

import com.market.marketapi.dao.ProductDAO;
import com.market.marketapi.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDTOService {
    @Autowired
    private ProductDAO productDAO;
    public Optional<ProductDTO> addProduct(ProductDTO productDTO){
        return productDAO.addProduct(productDTO);
    }
    public List<ProductDTO> getAll(){
        return productDAO.getAll();
    }
    public Optional<ProductDTO> getProduct(Integer idProduct){
        return productDAO.getProduct(idProduct);
    }
    public Optional<List<ProductDTO>> getByCategory(Integer idCategory){
        return productDAO.getByCategory(idCategory);
    }
    public Boolean deleteProduct(Integer idProduct){
        return productDAO.deleteProduct(idProduct);
    }
    public Boolean updateProduct(ProductDTO productDTO){
        return productDAO.updateProduct(productDTO);
    }
}
