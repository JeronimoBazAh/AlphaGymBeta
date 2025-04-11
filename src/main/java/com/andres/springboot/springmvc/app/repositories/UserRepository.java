package com.andres.springboot.springmvc.app.repositories;

import com.andres.springboot.springmvc.app.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Cliente, Integer> {
    Optional<Cliente> findByDocumento(String documento);

}
