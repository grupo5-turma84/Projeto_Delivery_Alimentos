package com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}