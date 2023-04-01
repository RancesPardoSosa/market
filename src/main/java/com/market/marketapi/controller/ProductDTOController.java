package com.market.marketapi.controller;

import com.market.marketapi.dto.ProductDTO;
import com.market.marketapi.service.ProductDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@ComponentScan("market-api")
public class ProductDTOController {
    @Autowired
    private ProductDTOService productDTOService;
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return new ResponseEntity<>(productDTOService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Integer idProduct){
        return productDTOService.getProduct(idProduct)
                .map(productDTO -> new ResponseEntity<>(productDTO,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") Integer idCategory){
        return productDTOService.getByCategory(idCategory)
                .map(productDTOS -> new ResponseEntity<>(productDTOS,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer idProduct){
        return productDTOService.deleteProduct(idProduct) ?
                new ResponseEntity(HttpStatus.OK) :
                new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
