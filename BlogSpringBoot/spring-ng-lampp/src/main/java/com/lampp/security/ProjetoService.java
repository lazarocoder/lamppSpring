package com.lampp.security;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lampp.dto.ProjetoDto;
import com.lampp.exception.ProjetoNotFoundException;
import com.lampp.model.Projeto;
import com.lampp.repository.ProjetoRepository;
import com.lampp.service.AuthService;

@Service
public class ProjetoService {

	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private AuthService authService;

	@Autowired
	private ProjetoRepository projetoRepository;

	@Transactional
	public List<ProjetoDto> showAllProjetos() {
		List<Projeto> projetos = projetoRepository.findAll();
		return projetos.stream().map(this::mapFromProjetoToDto).collect(toList());
	}

	@Transactional
	public void createProjeto(ProjetoDto projetoDto) {
		Projeto projeto = mapFromDtoToProjeto(projetoDto);
		projetoRepository.save(projeto);
	}

	@Transactional
	public ProjetoDto updateProjeto(Long id, ProjetoDto projetoDto) {
		Projeto projeto = projetoRepository.findById(id)
				.orElseThrow(() -> new ProjetoNotFoundException("For id " + id));
		projeto.setValor(projetoDto.getValor());
		projeto.setDescricao(projetoDto.getDescricao());
		projetoRepository.save(projeto);
		return mapFromProjetoToDto(projeto);
	}

	@Transactional
	public ProjetoDto readSingleProjeto(Long id) {
		Projeto projeto = projetoRepository.findById(id)
				.orElseThrow(() -> new ProjetoNotFoundException("For id " + id));
		return mapFromProjetoToDto(projeto);
	}

	private ProjetoDto mapFromProjetoToDto(Projeto projeto) {
		ProjetoDto projetoDto = new ProjetoDto();
		projetoDto.setId(projeto.getId());
		projetoDto.setValor(projeto.getValor());
		projetoDto.setDescricao(projeto.getDescricao());
		projetoDto.setUserName(projeto.getUserName());
		projetoDto.setDtCriacao(dtf.format(projeto.getDtCriacao()));
		if (projeto.getDtFinalizacao() != null) {
			projetoDto.setDtFinalizacao(dtf.format(projeto.getDtFinalizacao()));
		}
		return projetoDto;
	}

	private Projeto mapFromDtoToProjeto(ProjetoDto projetoDto) {
		Projeto projeto = new Projeto();
		projeto.setValor(projetoDto.getValor());
		projeto.setDescricao(projetoDto.getDescricao());
		User loggedInUser = authService.getCurrentUser()
				.orElseThrow(() -> new IllegalArgumentException("User Not Found"));
		projeto.setDtCriacao(LocalDateTime.now());
		projeto.setUserName(loggedInUser.getUsername());
		projeto.setDtFinalizacao(LocalDateTime.now());
		return projeto;
	}

	@Transactional
	public void deleteProjeto(Long id) {
		projetoRepository.deleteById(id);
	}
}
