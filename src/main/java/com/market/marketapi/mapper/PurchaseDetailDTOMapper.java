package com.market.marketapi.mapper;

import com.market.marketapi.dto.PurchaseDetailDTO;
import com.market.marketapi.entity.PurchaseDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring" , uses = {ProductDTOMapper.class})
public interface PurchaseDetailDTOMapper {
    @Mapping(source = "id.idProduct" , target = "idProduct")
    PurchaseDetailDTO toPurchaseDetailDTO(PurchaseDetail purchaseDetail);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase",ignore = true),
            @Mapping(target = "product",ignore = true),
            @Mapping(target = "id.idPurchase",ignore = true)
    })
    PurchaseDetail toPurchaseDetail(PurchaseDetailDTO purchaseDetailDTO);
}
