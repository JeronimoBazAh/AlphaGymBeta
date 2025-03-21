package com.andres.springboot.springmvc.app.repositories;

import com.andres.springboot.springmvc.app.entities.Compras;
import org.springframework.data.repository.CrudRepository;

public interface ComprasRepository extends CrudRepository<Compras,Integer> {

}
