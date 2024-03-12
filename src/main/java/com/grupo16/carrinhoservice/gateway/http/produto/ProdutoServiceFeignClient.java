package com.grupo16.carrinhoservice.gateway.http.produto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupo16.carrinhoservice.gateway.http.produto.json.ProdutoJson;

@FeignClient(value = "PRODUTO-SERVICE", path = "produtos")
public interface ProdutoServiceFeignClient {
	
	@GetMapping("{id}")
	ProdutoJson obterPorId(@PathVariable(value = "id") Long id);

}
