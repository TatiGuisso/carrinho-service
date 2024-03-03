package com.grupo16.carrinhoservice.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;

@Service
public class ObterPrecoItemUseCase {

	public void obter(Carrinho carrinho) {

		//TODO: implementar a integração com o microsservico ProdutoService

		//FIXME: Mock será removido (deveria estar na impl do gateway, mas não foi criado ainda)
		List<Item> listaComPreco = new ArrayList<>();

		carrinho.getItens().forEach(i -> {
			listaComPreco.add(Item.builder()
					.idProduto(i.getIdProduto())
					.quantidade(i.getQuantidade())
					.precoUnitario(5.0)
					.build());
		});

		for (Item itemComPreco : listaComPreco) {
			for (Item itemSemPreco : carrinho.getItens()) {
				if(itemComPreco.getIdProduto().equals(itemSemPreco.getIdProduto())) {
					itemSemPreco.setPrecoUnitario(itemComPreco.getPrecoUnitario());
					break;
				}
			}
		}
	}

}
