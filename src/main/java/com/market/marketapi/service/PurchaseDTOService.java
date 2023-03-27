package com.market.marketapi.service;

import com.market.marketapi.dao.PurchaseDAO;
import com.market.marketapi.dto.PurchaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseDTOService {
    @Autowired
    private PurchaseDAO purchaseDAO;
    public List<PurchaseDTO> getAll(){
        return purchaseDAO.getAll();
    }
    public Optional<PurchaseDTO> getPurchase(Integer idPurchase){
        return purchaseDAO.getPurchase(idPurchase);
    }
    public Optional<List<PurchaseDTO>> getByIdClient(String idClient){
        return purchaseDAO.getByIdClient(idClient);
    }
    public Optional<PurchaseDTO> save(PurchaseDTO purchaseDTO){
        return purchaseDAO.save(purchaseDTO);
    }
}
