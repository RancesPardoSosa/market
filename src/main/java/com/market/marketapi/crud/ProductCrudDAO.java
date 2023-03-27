package com.market.marketapi.crud;

import com.market.marketapi.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudDAO extends CrudRepository<Product,Integer> {

    Optional<List<Product>> findByIdCategory(Integer idCategory);

}
