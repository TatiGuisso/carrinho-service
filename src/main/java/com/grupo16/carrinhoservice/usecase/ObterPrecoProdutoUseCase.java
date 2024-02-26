package com.grupo16.carrinhoservice.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Produto;

@Service
public class ObterPrecoProdutoUseCase {

	public List<Produto> obter(List<Produto> produtos) {
		
		// TODO implementar a integração com o microsservico ProdutoService
		
		//Mock: será removido
		List<Produto> listaComPreco = new ArrayList<>();
		listaComPreco.add(new Produto(1L, 1, 10.0));
        listaComPreco.add(new Produto(2L, 2, 15.0));
        listaComPreco.add(new Produto(3L, 1, 20.0));
		
		
		return listaComPreco;
	}

}
