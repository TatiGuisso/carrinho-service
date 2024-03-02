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
		listaComPreco.add(Item.builder().idProduto(10L).quantidade(1).precoUnitario(25.0).build());
        listaComPreco.add(Item.builder().idProduto(20L).quantidade(1).precoUnitario(18.0).build());
        listaComPreco.add(Item.builder().idProduto(30L).quantidade(1).precoUnitario(31.0).build());
		
		
		return listaComPreco;
	}

}
