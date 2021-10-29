package com.lampp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lampp.dto.ProjetoDto;
import com.lampp.security.ProjetoService;

@RestController
@RequestMapping("/api/projetos/")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@PostMapping
	public ResponseEntity createProjeto(@RequestBody ProjetoDto projetoDto) {
		projetoService.createProjeto(projetoDto);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProjetoDto> updateProjeto(@PathVariable Long id, @RequestBody ProjetoDto projetoDto) {
		projetoDto = projetoService.updateProjeto(id, projetoDto);
		return ResponseEntity.ok(projetoDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProjeto(@PathVariable Long id) {
		projetoService.deleteProjeto(id);
	}

	@GetMapping("public/all")
	public ResponseEntity<List<ProjetoDto>> showAllProjetos() {
		return new ResponseEntity<>(projetoService.showAllProjetos(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProjetoDto> getSingleProjeto(@PathVariable @RequestBody Long id) {
		return new ResponseEntity<>(projetoService.readSingleProjeto(id), HttpStatus.OK);
	}

	@GetMapping("/public/get/{id}")
	public ResponseEntity<ProjetoDto> getPublicSingleProjeto(@PathVariable @RequestBody Long id) {
		return new ResponseEntity<>(projetoService.readSingleProjeto(id), HttpStatus.OK);

	}
}
