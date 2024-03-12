package com.grupo16.carrinhoservice.gateway;

import com.grupo16.carrinhoservice.gateway.http.produto.json.ProdutoJson;

public interface ProdutoServiceGateway {
	
	ProdutoJson obterPorId(Long id);

}
