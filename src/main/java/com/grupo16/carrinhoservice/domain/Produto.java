package com.grupo16.carrinhoservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Produto {
	
	private Long id;
	private Integer quantidade;
	private Double precoUnitario;

}
