package com.market.marketapi.mapper;

import com.market.marketapi.dto.PurchaseDTO;
import com.market.marketapi.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseDetailDTOMapper.class})
public interface PurchaseDTOMapper {
    PurchaseDTO toPurchaseDTO(Purchase purchase);
    List<PurchaseDTO> toPurchaseDtoList(List<Purchase> purchases);
    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "client" , ignore = true)
    })
    Purchase toPurchase(PurchaseDTO purchaseDTO);
}
