package com.grupo16.carrinhoservice.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.gateway.ProdutoServiceGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterPrecoItemUseCase {
	
	private ProdutoServiceGateway produtoServiceGateway;

	public void obter(Carrinho carrinho) {

		//TODO: implementar a integração com o microsservico ProdutoService
		
		List<Long> produtoIdList = carrinho.getItens().stream().mapToLong(Item::getIdProduto).boxed().toList();
		
		List<Item> listaComPreco = produtoServiceGateway.obterPorId(produtoIdList);

		//FIXME: Mock será removido (deveria estar na impl do gateway, mas não foi criado ainda)
//		List<Item> listaComPreco = new ArrayList<>();

//		carrinho.getItens().forEach(i -> {
//			listaComPreco.add(Item.builder()
//					.idProduto(i.getIdProduto())
//					.quantidade(i.getQuantidade())
//					.precoUnitario(5.0)
//					.build());
//		});

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
