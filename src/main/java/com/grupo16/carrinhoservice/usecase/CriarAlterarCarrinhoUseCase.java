package com.grupo16.carrinhoservice.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarAlterarCarrinhoUseCase {
	
	private CarrinhoRepositoryGateway carrinhoRepositoryGateway;
	
	private ObterPrecoItemUseCase obterPrecoItemUseCase;

	public Carrinho salvar(Carrinho carrinho) {
		
		List<Item> listaComPreco = obterPrecoItemUseCase.obter(carrinho.getItens());
		
		//TODO pegar precos do produtosComPreco e colocar no carrinho
		//TODO pegar idCarrinho colocar no carrinho
		
		for (Item itemComPreco : listaComPreco) {
			for (Item itemSemPreco : carrinho.getItens()) {
				if(itemComPreco.getId().equals(itemSemPreco.getId())) {
					itemSemPreco.setPrecoUnitario(itemComPreco.getPrecoUnitario());
					break;
				}
			}
		}
		
		Long idCarrinho = carrinhoRepositoryGateway.salvar(carrinho);
		
		
		carrinho.setId(idCarrinho);
		
		return carrinho;
	}

}
