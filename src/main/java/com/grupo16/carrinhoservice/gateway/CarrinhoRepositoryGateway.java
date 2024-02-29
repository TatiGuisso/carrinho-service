package com.grupo16.carrinhoservice.gateway;

import java.util.Optional;

import com.grupo16.carrinhoservice.domain.Carrinho;

public interface CarrinhoRepositoryGateway {

	Long salvar(Carrinho carrinho);

	Optional<Carrinho> obter(Carrinho carrinho);

}
