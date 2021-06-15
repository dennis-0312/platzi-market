package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//uses = ProductMapper.class: esto hace referencia al @Mapping(source = "productos" , target = "item"),
//para indicalre que ya tiene un mapeo.
@Mapper(componentModel = "spring", uses = PurchaseItemMapper.class)
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos" , target = "item")
    })
    Purchase toPurchase(Compra compra);
    //Esto metodo se asigna porque queremos obtener una petición de variso registros(una lista), pero ya
    //no se mapea prorque arriba ya esta el mapeo.
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);


}
