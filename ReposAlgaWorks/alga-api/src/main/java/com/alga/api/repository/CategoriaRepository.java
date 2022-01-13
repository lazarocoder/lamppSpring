package com.alga.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alga.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public Categoria findByCodigo(Long codigo);

}
