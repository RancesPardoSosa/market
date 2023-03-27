package com.market.marketapi.mapper;

import com.market.marketapi.dto.ClientDTO;
import com.market.marketapi.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientDTOMapper {
    ClientDTO toClientDTO(Client client);
    @InheritInverseConfiguration
    @Mapping(target = "purchases" , ignore = true)
    Client toClient(ClientDTO clientDTO);
}
