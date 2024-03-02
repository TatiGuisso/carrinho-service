package com.grupo16.carrinhoservice.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Carrinho {
	
	@Setter
	private Long id;
	private Long idUsuario;
	private Status status;
	private List<Item> itens;

	public Double getValorTotal() {
		return itens.stream().mapToDouble(Item::getPrecoTotal).sum();
	}
	

}
