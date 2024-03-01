package com.grupo16.carrinhoservice.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;
import com.grupo16.carrinhoservice.usecase.exception.CarrinhoNaoEncontradoException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ObterCarrinhoUseCase {
	
	private CarrinhoRepositoryGateway carrinhoRepositoryGateway;

	public Carrinho obterPorIdAndIdUsuario(Carrinho carrinho) {

		Optional<Carrinho> carrinhoOp = carrinhoRepositoryGateway.obterPorIdAndIdUsuario(carrinho);

		if(carrinhoOp.isEmpty()) {
			log.warn("Carrinho não encontrado. carrinho={}", carrinho);
			throw new CarrinhoNaoEncontradoException();
		}
		return carrinhoOp.get();
	}

}
