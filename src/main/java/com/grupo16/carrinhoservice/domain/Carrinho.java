package com.grupo16.carrinhoservice.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Carrinho {
	
	private Long id;
	private List<Produto> produtos;
	private Double valorTotal;

}
