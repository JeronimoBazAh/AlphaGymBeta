package com.andres.springboot.springmvc.app.services;

import com.andres.springboot.springmvc.app.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface Service<T>{

    List<T>  findAll();
    Cliente save(T user);
    Optional<T> findById(Integer id);
    void remove(Integer id);
}
