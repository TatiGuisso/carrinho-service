package com.grupo16.carrinhoservice.gateway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.domain.Status;
import com.grupo16.carrinhoservice.gateway.controller.json.CarrinhoJson;
import com.grupo16.carrinhoservice.gateway.controller.json.ItemJson;
import com.grupo16.carrinhoservice.usecase.CriarAlterarCarrinhoUseCase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("carrinhos")
@AllArgsConstructor
public class CarrinhoController {
	
	private CriarAlterarCarrinhoUseCase criarAlterarCarrinhoUseCase;
	
	@PostMapping("{idUsuario}")
	public CarrinhoJson salvar(
			@PathVariable(name = "idUsuario") Long idUsuario,
			@RequestBody List<ItemJson> itensJson) {
		log.trace("Start idUsuario={}, itensJson={}", idUsuario, itensJson);
		
		List<Item> itens = itensJson.stream().map(p -> p.mapperToDomain()).toList();
		
		Carrinho carrinho = Carrinho.builder()
				.idUsuario(idUsuario)
				.status(Status.ATIVO)
				.itens(itens)
				.build();
		
		Carrinho carrinhoSalvo = criarAlterarCarrinhoUseCase.salvar(carrinho);
		
		CarrinhoJson carrinhoSalvoJson = new CarrinhoJson(carrinhoSalvo);
		
		log.trace("End carrinhoSalvoJson={}", carrinhoSalvoJson);
		return carrinhoSalvoJson;
	}
	
	@PutMapping("{id}/{idUsuario}")
	public void alterar(
			@PathVariable(name = "id") Long idCarrinho,
			@PathVariable(name = "idUsuario") Long idUsuario,
			@RequestBody List<ItemJson> itensJson) {
		log.trace("Start idCarrinho={}, idUsuario={}, itensJson={}", idCarrinho, idUsuario, itensJson);
		
		List<Item> itens = itensJson.stream().map(ItemJson::mapperToDomain).toList();
		
		Carrinho carrinho = Carrinho.builder()
				.id(idCarrinho)
				.idUsuario(idUsuario)
				.status(Status.ATIVO)
				.itens(itens)
				.build();
		
		criarAlterarCarrinhoUseCase.alterar(carrinho);
	}
	
	@GetMapping("{idUsuario}")
	public Carrinho obter(@PathVariable(name = "idUsuario") Long idUsuario) {
		//TODO implementar obter carrinho ativo.
		
		
		
		return null;
	}

}
