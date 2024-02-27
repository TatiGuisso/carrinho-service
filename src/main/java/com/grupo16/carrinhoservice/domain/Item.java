package com.grupo16.carrinhoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	private Long id;
	private Long idProduto;
	private Integer quantidade;
	
	@Setter
	private Double precoUnitario;
	private Carrinho carrinho;
	
	public Double getPrecoTotal() {
		return precoUnitario * quantidade;
	}

}
