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
	
	private Long idCarrinho;
	private Long idUsuario;
	private List<ItemJson> itens;
	private Double valorTotal;
	
	public CarrinhoJson(Carrinho carrinho) {
		idCarrinho = carrinho.getId();
		idUsuario = carrinho.getIdUsuario();
		itens = carrinho.getItens().stream().map(ItemJson::new).toList();
		valorTotal = carrinho.getValorTotal();
	}

}
