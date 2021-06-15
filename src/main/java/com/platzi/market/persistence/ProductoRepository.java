package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    //Los retornos se expoenen así proque en algunso casos no hay mapeador, esto es para todos los metodos.
    @Override
    public Optional<List<Product>> getByCategoy(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    //Se agrega un lanbda porque Optional no tiene un mepeador entonces se mapea.
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

//    @Override
//    public Optional<List<Product>> getPriceThanTo(double price) {
//        Optional<List<Producto>> productos = productoCrudRepository.findByPrecioVentaThan(price);
//        return productos.map(prods -> mapper.toProducts(prods));
//    }

    @Override
    public Optional<Product> getProductById(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        Product product1 = mapper.toProduct(productoCrudRepository.save(producto));
        return product1;
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

//    public List<Producto> selectCategoria(int idCategoria) {
//        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
//    }

//    public Optional<List<Producto>> getEscasos(int cantidad) {
//        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
//    }

//    public Optional<List<Producto>> getPrecioMayorA(double precioVenta) {
//        return productoCrudRepository.findByPrecioVentaThan(precioVenta);
//    }

//    public Optional<Producto> getProductoById(int idProducto) {
//        return productoCrudRepository.findById(idProducto);
//    }

//    public Producto saveProdcuto(Producto producto) {
//        return productoCrudRepository.save(producto);
//    }

//    public void deleteProducto(int idProducto) {
//        productoCrudRepository.deleteById(idProducto);
//    }



}
