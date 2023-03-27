package com.market.marketapi.crud;

import com.market.marketapi.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudDAO extends CrudRepository<Purchase,Integer> {
    Optional<List<Purchase>> findByIdClient(String idClient);
}
