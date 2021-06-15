package com.platzi.market.persistence.entity;

import javax.persistence.*;

//@Entity: Esta anotación le hará entender a java de que esta clase se comportará como una clase que mapea una tabla de la base de datos.
//@Table: Esta anotación hace referencia al nombre de la tabla que está en la base de datos, para asociarla
@Entity
@Table(name = "productos")
public class Producto {

    //@Id: Esta anotación es para decirle que es la llave primaria.
    //GenerateValue: Nos permitirá que java genere el valor de manera automática
    //@Column: Siempre y cuando la variable priva que hace referencia al campo desa diferente al campo que est la base de datos. Ejm: id_producto(base de datos) = idProducto(Clase entidad).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    //RELATIONSHIP
    //@ManyToOne: Significado de muchos a uno
    //JoinColumn: Aquí hacemos referencia al campo relacionado.
    //insertable = false, updatable = false: Etas anotaciones significa que no vamos a insertar, ni actualizar una nueva categoría, para hacerlo, debemos hacerlo directamente en el entity categoría.
    //Esto solo nso sirve para obtener los datos, como si fuera un inner join.
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;



    //GETTER AND SETTER
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
