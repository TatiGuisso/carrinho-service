package com.grupo16.carrinhoservice.gateway.controller.json;

import com.grupo16.carrinhoservice.domain.Produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProdutoJson {
	
	private Long id;
	private Integer quantidade;
	private Double precoUnitario;
	
	public Produto mapperToDomain() {
		return Produto.builder()
				.id(id)
				.quantidade(quantidade)
				.precoUnitario(precoUnitario)
				.build();
	}
	
	public ProdutoJson(Produto produto) {
		id = produto.getId();
		quantidade = produto.getQuantidade();
		precoUnitario = produto.getPrecoUnitario();
	}

}
