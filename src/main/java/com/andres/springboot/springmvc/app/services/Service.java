package com.andres.springboot.springmvc.app.services;

import com.andres.springboot.springmvc.app.entities.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface Service<T>{

    List<T>  findAll();
    Cliente save(T user);

    @Transactional(readOnly = true)
    Optional<Cliente> findByDocumento(String documento);

    Optional<T> findById(Integer id);
    void remove(Integer id);
}
