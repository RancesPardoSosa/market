package com.market.marketapi.dao;

import com.market.marketapi.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseDAO {
    List<PurchaseDTO> getAll();
    Optional<PurchaseDTO> getPurchase(Integer idPurchase);
    Optional<List<PurchaseDTO>> getByIdClient(String idClient);
    Optional<PurchaseDTO> save(PurchaseDTO purchaseDTO);

}
