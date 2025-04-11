package com.andres.springboot.springmvc.app.services;

import com.andres.springboot.springmvc.app.entities.Cliente;

import com.andres.springboot.springmvc.app.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserServiceImpl implements Service<Cliente> {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findByDocumento(String documento){
        return repository.findByDocumento(documento);
    };


    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Cliente save(Cliente user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
