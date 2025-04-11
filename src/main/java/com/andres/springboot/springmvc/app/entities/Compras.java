package com.andres.springboot.springmvc.app.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
public class Compras {
    @Id  // Importación correcta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "producto")
    private String producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Double precio;

      // Relación con Cliente
    @Column(name = "cliente_id") // Nombre correcto en la base de datos
    private Integer cliente;

    @Column(name = "fechaCompra")
    private LocalDate fecha;

    public Compras() {
    }

    public Compras(Integer id, String producto, Integer cantidad, Double precio, Integer cliente) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.cliente = cliente;
    }

    @PrePersist

    public void prePersist() {
        fecha = LocalDate.now();
    }

    // Getters y Setters
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getProducto() { return producto; }


    public void setProducto(String producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getCliente() { return cliente; }
    public void setCliente(Integer cliente) { this.cliente = cliente; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}