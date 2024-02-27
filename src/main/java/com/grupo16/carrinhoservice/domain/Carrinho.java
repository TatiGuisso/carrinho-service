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
	private List<Item> itens;

	public Double getValorTotal() {
		return 500D; //TODO iterar na lista de produtos e calcular o valor total.
	}
	

}
