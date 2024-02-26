package com.grupo16.carrinhoservice.gateway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Produto;
import com.grupo16.carrinhoservice.gateway.controller.json.CarrinhoJson;
import com.grupo16.carrinhoservice.gateway.controller.json.ProdutoJson;
import com.grupo16.carrinhoservice.usecase.CriarAlterarCarrinhoUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("carrinhos")
@AllArgsConstructor
public class CarrinhoController {
	
	private CriarAlterarCarrinhoUseCase criarAlterarCarrinhoUseCase;
	
	@PostMapping
	public CarrinhoJson salvar(
			@RequestBody List<ProdutoJson> produtosJson) {
		log.trace("Start produtoJson={}", produtosJson);
		
		List<Produto> produtos = produtosJson.stream().map(p -> p.mapperToDomain()).toList();
		
		Carrinho carrinho = Carrinho.builder()
				.produtos(produtos)
				.build();
		
		Carrinho carrinhoSalvo = criarAlterarCarrinhoUseCase.salvar(carrinho);
		
		//TODO fazer o mapper do domain para json 
		
		CarrinhoJson carrinhoSalvoJson = new CarrinhoJson(carrinhoSalvo);
		
		log.trace("End carrinhoSalvoJson={}", carrinhoSalvoJson);
		return carrinhoSalvoJson;
	}

}
