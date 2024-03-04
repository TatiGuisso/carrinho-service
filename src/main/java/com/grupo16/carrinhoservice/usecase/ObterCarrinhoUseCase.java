package com.grupo16.carrinhoservice.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Status;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;
import com.grupo16.carrinhoservice.usecase.exception.CarrinhoNaoEncontradoException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ObterCarrinhoUseCase {
	
	private CarrinhoRepositoryGateway carrinhoRepositoryGateway;
	
	private ObterPrecoItemUseCase obterPrecoItemUseCase;

	public Carrinho obterPorIdAndIdUsuario(Carrinho carrinho) {

		Optional<Carrinho> carrinhoOp = carrinhoRepositoryGateway.obterPorIdAndIdUsuario(carrinho);

		if(carrinhoOp.isEmpty()) {
			log.warn("Carrinho não encontrado. carrinho={}", carrinho);
			throw new CarrinhoNaoEncontradoException();
		}
		return carrinhoOp.get();
	}

	public Carrinho obterPorIdEStatus(Long idCarrinho, Status ativo ) {
		
		Optional<Carrinho> carrinhoOp = carrinhoRepositoryGateway.obterPorIdEStatus(idCarrinho, ativo);
		
		if(carrinhoOp.isEmpty()) {
			log.warn("Carrinho do usuario não encontrado. idCarrinho={}", idCarrinho);
			throw new CarrinhoNaoEncontradoException();
		}
		
		Carrinho carrinho = carrinhoOp.get();
		obterPrecoItemUseCase.obter(carrinho); 
		
		return carrinho;
	}

}
