package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// También podemos usar JpaRepository
public interface ProductRepository extends CrudRepository<Product, Integer>{}
