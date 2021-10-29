package com.lampp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lampp.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
