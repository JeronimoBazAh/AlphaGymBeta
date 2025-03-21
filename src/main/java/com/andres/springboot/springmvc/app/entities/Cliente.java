package com.andres.springboot.springmvc.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="clientes")
public class Cliente {

    public Cliente() {
    }

    public Cliente(Integer id, String documento, String nombre, String apellido, String celular, LocalDate fecha) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.fechaAlta = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotEmpty
    @Column(name = "Documento")
    private String documento;

    @NotEmpty
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    @NotEmpty
    private String apellido;
    @Column(name = "Celular")

    @NotEmpty
    private String celular;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Column(name="Sexo")
    private String sexo;

    @PrePersist
    public void prePersist() {
        this.fechaAlta = LocalDate.now();
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}