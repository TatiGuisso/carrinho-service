package com.grupo16.carrinhoservice.gateway;

import java.util.Optional;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Status;

public interface CarrinhoRepositoryGateway {

	Long salvar(Carrinho carrinho);

	Optional<Carrinho> obterPorIdAndIdUsuario(Carrinho carrinho);
	
	void alterar(Carrinho carrinho);

	Optional<Carrinho> obterPorIdEStatus(Long idUsuario, Status ativo);

	void inativar(Carrinho carrinho);

}
