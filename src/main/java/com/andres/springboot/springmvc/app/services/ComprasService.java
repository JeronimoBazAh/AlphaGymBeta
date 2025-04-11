package com.andres.springboot.springmvc.app.services;

import com.andres.springboot.springmvc.app.entities.Cliente;
import com.andres.springboot.springmvc.app.entities.Compras;
import com.andres.springboot.springmvc.app.repositories.ComprasRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ComprasService implements Service<Compras>{

    private final ComprasRepository repository;

    public ComprasService(ComprasRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Compras> findAll() {
        return (List<Compras>) repository.findAll();
    }

    @Override
    public Cliente save(Compras user) {
        return null;
    }

    @Override
    public Optional<Cliente> findByDocumento(String documento) {
        return Optional.empty();
    }

    @Override
    public Optional<Compras> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void remove(Integer id) {

    }
}
