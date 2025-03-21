package com.andres.springboot.springmvc.app.repositories;

import com.andres.springboot.springmvc.app.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Cliente, Integer> {

}
