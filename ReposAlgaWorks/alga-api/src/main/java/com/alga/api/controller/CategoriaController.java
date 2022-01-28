package com.alga.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alga.api.model.Categoria;
import com.alga.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();

	}
	/*
	 * @GetMapping private ResponseEntity<?> listarTodos() { List<Categoria>
	 * categoria = categoriaRepository.findAll(); return !categoria.isEmpty() ?
	 * ResponseEntity.ok(categoria) : ResponseEntity.noContent( ).build();
	 * 
	 * }
	 */

	/*
	 * @PostMapping
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public void salvarCategoria(@RequestBody
	 * Categoria categoria, HttpServletResponse response) { Categoria categoriaSalva
	 * = categoriaRepository.save(categoria); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentServletMapping().path("/codigo")
	 * .buildAndExpand(categoriaSalva.getCodigo()).toUri();
	 * response.setHeader("Location", uri.toASCIIString()); }
	 */

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/codigo")
				.buildAndExpand(categoriaSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(categoriaSalva);
	}

	/*
	 * @GetMapping("/{codigo}") public Categoria encontrarCodigo(@PathVariable Long
	 * codigo) { return categoriaRepository.getById(codigo);
	 * 
	 * 
	 * }
	 */
	
	@GetMapping("/{codigo}")
	public Categoria encontrarCodigo(Long codigo) {
		return categoriaRepository.findByCodigo(codigo);

	}

}