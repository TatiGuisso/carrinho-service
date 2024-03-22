package com.grupo16.carrinhoservice.usecase;

import org.springframework.stereotype.Service;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Status;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;
import com.grupo16.carrinhoservice.usecase.exception.CarrinhoNaoEncontradoException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CriarAlterarCarrinhoUseCase {

	private CarrinhoRepositoryGateway carrinhoRepositoryGateway;

	private ObterPrecoItemUseCase obterPrecoItemUseCase;

	private ObterCarrinhoUseCase obterCarrinhoUseCase;

	public Carrinho salvar(Carrinho carrinho) {
		obterPrecoItemUseCase.obter(carrinho);
		Long idCarrinho = carrinhoRepositoryGateway.salvar(carrinho);
		carrinho.setId(idCarrinho);
		return carrinho;
	}

	public void alterar(Carrinho carrinho) {
		Carrinho carrinhoEncontrado = obterCarrinhoUseCase.obterPorIdAndIdUsuario(carrinho);
		
		if(carrinhoEncontrado.getStatus().equals(Status.INATIVO)) {
			throw new CarrinhoNaoEncontradoException();
		}
		
		Carrinho carrinhoAlterado = Carrinho.builder()
				.id(carrinhoEncontrado.getId())
				.idUsuario(carrinhoEncontrado.getIdUsuario())
				.status(carrinho.getStatus())
				.itens(carrinho.getItens())
				.build();

		carrinhoRepositoryGateway.alterar(carrinhoAlterado);		
	}

	public void inativar(Long idCarrinho) {
		Carrinho carrinhoEncontrado = obterCarrinhoUseCase.obterPorId(idCarrinho);
		
		Carrinho carrinho = Carrinho.builder()
				.id(idCarrinho)
				.idUsuario(carrinhoEncontrado.getIdUsuario())
				.status(Status.INATIVO)
				.build();
		
		carrinhoRepositoryGateway.inativar(carrinho);
	}

}
