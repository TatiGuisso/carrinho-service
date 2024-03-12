package com.grupo16.carrinhoservice.gateway;

import java.util.List;

import com.grupo16.carrinhoservice.domain.Item;

public interface ProdutoServiceGateway {
	
	List<Item> obterPorId(List<Long> id);

}
