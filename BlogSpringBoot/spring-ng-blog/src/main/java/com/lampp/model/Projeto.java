package com.lampp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_PROJETO")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column
	private Long valor;

	@Lob
	@Column
	@NotEmpty
	private String descricao;

	@Column
	private LocalDateTime dtCriacao;

	@Column
	private LocalDateTime dtFinalizacao;

	@Column
	@NotBlank
	private String userName;

}
