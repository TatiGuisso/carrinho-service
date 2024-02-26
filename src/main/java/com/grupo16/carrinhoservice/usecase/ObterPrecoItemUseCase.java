package com.grupo16.carrinhoservice.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Item;

@Service
public class ObterPrecoItemUseCase {

	public List<Item> obter(List<Item> itens) {
		
		// TODO implementar a integração com o microsservico ProdutoService
		
		//Mock: será removido
		List<Item> listaComPreco = new ArrayList<>();
		listaComPreco.add(new Item(1L, 1, 10.0));
        listaComPreco.add(new Item(2L, 2, 15.0));
        listaComPreco.add(new Item(3L, 1, 20.0));
		
		
		return listaComPreco;
	}

}
