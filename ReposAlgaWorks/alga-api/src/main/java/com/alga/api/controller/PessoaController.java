package com.alga.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alga.api.model.Pessoa;
import com.alga.api.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> buscarPessoas() {
		return pessoaRepository.findAll();

	}

	/*
	 * @GetMapping("/codigo") public Pessoa buscarPorCodigo(Long codigo) { return
	 * pessoaRepository.findByCodigo(codigo); }
	 */

	@GetMapping("/{codigo}")
	public Pessoa buscarPorId(Long codigo) {
		return pessoaRepository.findByCodigo(codigo);

	}
}
