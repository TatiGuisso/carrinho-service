package com.grupo16.carrinhoservice.gateway.repository.mysql;

import org.springframework.stereotype.Component;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;

@Component
public class CarrinhoMySqlGateway implements CarrinhoRepositoryGateway {

	@Override
	public Long salvar(Carrinho carrinho) {
		// TODO Auto-generated method stub
		return 1L;
	}
	

}
