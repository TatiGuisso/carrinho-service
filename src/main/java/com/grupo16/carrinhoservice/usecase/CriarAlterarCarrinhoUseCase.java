package com.grupo16.carrinhoservice.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Produto;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarAlterarCarrinhoUseCase {
	
	private CarrinhoRepositoryGateway carrinhoRepositoryGateway;
	
	private ObterPrecoProdutoUseCase obterPrecoProdutoUseCase;

	public Carrinho salvar(Carrinho carrinho) {
		
		List<Produto> listaComPreco = obterPrecoProdutoUseCase.obter(carrinho.getProdutos());
		
		//TODO pegar precos do produtosComPreco e colocar no carrinho
		//TODO pegar idCarrinho colocar no carrinho
		
		for (Produto produtoComPreco : listaComPreco) {
			for (Produto produtoSemPreco : carrinho.getProdutos()) {
				if(produtoComPreco.getId().equals(produtoSemPreco.getId())) {
					produtoSemPreco.setPrecoUnitario(produtoComPreco.getPrecoUnitario());
					break;
				}
			}
		}
		
		Long idCarrinho = carrinhoRepositoryGateway.salvar(carrinho);
		
		
		carrinho.setId(idCarrinho);
		
		return carrinho;
	}

}
