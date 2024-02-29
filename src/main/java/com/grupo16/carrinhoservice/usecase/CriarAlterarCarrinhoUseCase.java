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
		
		//FIXME remover mock do obterPrecoItemUseCase e chamar Produto-Service.
		List<Item> listaComPreco = obterPrecoItemUseCase.obter(carrinho.getItens());
		
		for (Item itemComPreco : listaComPreco) {
			for (Item itemSemPreco : carrinho.getItens()) {
				if(itemComPreco.getIdProduto().equals(itemSemPreco.getIdProduto())) {
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
