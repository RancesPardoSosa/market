package com.market.marketapi.dao;

import com.market.marketapi.crud.PurchaseCrudDAO;
import com.market.marketapi.dto.PurchaseDTO;
import com.market.marketapi.entity.Purchase;
import com.market.marketapi.mapper.PurchaseDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseImpl implements PurchaseDAO {
    @Autowired
    private PurchaseCrudDAO purchaseCrudDAO;
    @Autowired
    private PurchaseDTOMapper mapper;
    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toPurchaseDtoList((List<Purchase>) purchaseCrudDAO.findAll());
    }

    @Override
    public Optional<PurchaseDTO> getPurchase(Integer idPurchase) {
        return purchaseCrudDAO.findById(idPurchase)
                .map(purchase -> mapper.toPurchaseDTO(purchase));
    }

    @Override
    public Optional<List<PurchaseDTO>> getByIdClient(String idClient) {
        return purchaseCrudDAO.findByIdClient(idClient)
                .map(purchases -> mapper.toPurchaseDtoList(purchases));
    }

    @Override
    public Optional<PurchaseDTO> save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toPurchase(purchaseDTO);
        purchase.getPurchaseDetails().forEach(purchaseDetail -> purchaseDetail.setPurchase(purchase));
        return Optional.of(mapper.toPurchaseDTO(purchaseCrudDAO.save(purchase)));
    }
}
