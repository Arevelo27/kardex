package com.todo1.systemkardex.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long idArticulo; //NOT NULL,

    @NotEmpty
    private String descripcion; //NOT NULL,

    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta; //NOT NULL,

    @NotNull
    @Column(name = "precio_costo")
    private double precioCosto; //NOT NULL,

    @NotNull
    private int stock; //NOT NULL,

    @NotEmpty
    @Column(name = "cod_tipo_articulo")
    private Long codTipoArticulo; //NOT NULL,

    @NotNull
    @Column(name = "cod_tipo_producto")
    private Long codTipoProducto; //NOT NULL,

    @NotEmpty
    @Column(name = "fecha_ingreso")
    private String fechaIngreso; //NOT NULL,

    public Articulo() {
    }

    public Articulo(Long idArticulo, String descripcion, double precioVenta, double precioCosto, int stock, Long codTipoArticulo, Long codTipoProducto, String fechaIngreso) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.stock = stock;
        this.codTipoArticulo = codTipoArticulo;
        this.codTipoProducto = codTipoProducto;
        this.fechaIngreso = fechaIngreso;
    }
}
