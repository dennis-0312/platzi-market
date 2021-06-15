package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Extendemos de CrudRepository y le tenemos que pasar el nombre de clase de la tabla, y el tipo de campo de la pk.
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    //Optional<List<Producto>> findByPrecioVentaThan(double precioVenta);
}
