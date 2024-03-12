package com.grupo16.carrinhoservice.gateway.http.produto.json;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProdutoJson {
	
	private Long id;
	private Double precoUnitario;

}
