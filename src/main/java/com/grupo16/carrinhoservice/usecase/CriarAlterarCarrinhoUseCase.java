package com.grupo16.carrinhoservice.usecase;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;

@Service
public class CriarAlterarCarrinhoUseCase {
	
	private ObterPrecoProdutoUseCase obterPrecoProdutoUseCase;

	public Long salvar(Carrinho carrinho) {
		
		Carrinho carrinhoComPreco = obterPrecoProdutoUseCase.obter(carrinho);
		
		
		
		return null;
	}

}
