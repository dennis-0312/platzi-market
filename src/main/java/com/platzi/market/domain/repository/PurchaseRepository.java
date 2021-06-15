package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    //Que pasa si encontramso un cliente que no tenga compras, para eso asignamos un Optional, para controlar
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
//mago electrico, excavadora,barbarril,bruja madre,bolade feugo, bandida, cañon con ruedas, principe oscuro