package com.lampp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoDto {

	private Long id;

	private String descricao;

	private Long valor;

	private String userName;

	private String dtCriacao;

	private String dtFinalizacao;

}
