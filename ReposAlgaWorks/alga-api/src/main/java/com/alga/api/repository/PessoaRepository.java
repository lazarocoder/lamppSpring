package com.alga.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alga.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public List<Pessoa> findByAtivo(Boolean ativo);;

	public Pessoa findByCodigo(Long codigo);
	

	

}
