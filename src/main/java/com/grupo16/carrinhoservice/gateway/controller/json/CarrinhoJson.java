package com.grupo16.carrinhoservice.gateway.controller.json;

import java.util.List;

import com.grupo16.carrinhoservice.domain.Carrinho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class CarrinhoJson {
	
	private Long id;
	private List<ProdutoJson> produtos;
	private Double valorTotal;
	
	public CarrinhoJson(Carrinho carrinho) {
		id = carrinho.getId();
		produtos = carrinho.getProdutos().stream().map(ProdutoJson::new).toList();
		valorTotal = carrinho.getValorTotal();
	}

}
