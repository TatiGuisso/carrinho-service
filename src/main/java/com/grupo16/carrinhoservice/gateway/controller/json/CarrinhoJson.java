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
	private List<ItemJson> itens;
	private Double valorTotal;
	
	public CarrinhoJson(Carrinho carrinho) {
		id = carrinho.getId();
		itens = carrinho.getItens().stream().map(ItemJson::new).toList();
		valorTotal = carrinho.getValorTotal();
	}

}
