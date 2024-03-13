package com.grupo16.carrinhoservice.gateway.repository.mysql;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.domain.Status;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;
import com.grupo16.carrinhoservice.gateway.exception.ErroAoAcessarBancoDeDadosException;
import com.grupo16.carrinhoservice.gateway.repository.jpa.CarrinhoRepository;
import com.grupo16.carrinhoservice.gateway.repository.jpa.ItemRepository;
import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.CarrinhoEntity;
import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.ItemEntity;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class CarrinhoMySqlGateway implements CarrinhoRepositoryGateway {
	
	private CarrinhoRepository carrinhoRepository;
	
	private ItemRepository itemRepository;

	@Override
	@Transactional
	public Long salvar(Carrinho carrinho) {
		
		try {
			CarrinhoEntity carrinhoEntity = new CarrinhoEntity(carrinho);
			CarrinhoEntity carrinhoSalvo = carrinhoRepository.save(carrinhoEntity);
			
			salvarItens(carrinho, carrinhoSalvo);
			return carrinhoSalvo.getId();
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ErroAoAcessarBancoDeDadosException();
		}
	}

	@Override
	public Optional<Carrinho> obterPorIdAndIdUsuario(Carrinho carrinho) {
		try {
			
			Optional<Carrinho> carrinhoOp = Optional.empty();
			
			Optional<CarrinhoEntity> carrinhoEntityOp = 
					carrinhoRepository.findByIdAndIdUsuario(carrinho.getId(),carrinho.getIdUsuario());
			
			carrinhoOp = checarSeCarrinhoEstaPresente(carrinhoOp, carrinhoEntityOp);
			
			return carrinhoOp;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ErroAoAcessarBancoDeDadosException();
		}
	}

	@Override
	@Transactional
	public void alterar(Carrinho carrinho) {
		try {
			itemRepository.deleteByCarrinhoId(carrinho.getId());
			
			CarrinhoEntity carrinhoEntity = new CarrinhoEntity(carrinho);
			salvarItens(carrinho, carrinhoEntity);	
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDeDadosException();
		}
	}
	
	@Override
	public Optional<Carrinho> obterPorId(Long idCarrinho) {
		try {
			Optional<Carrinho> carrinhoOp = Optional.empty();
			
			Optional<CarrinhoEntity> carrinhoEntityOp = carrinhoRepository.findById(idCarrinho);
			
			carrinhoOp = checarSeCarrinhoEstaPresente(carrinhoOp, carrinhoEntityOp);
			
			return carrinhoOp;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDeDadosException();
		}
	}
	
	@Override
	public void inativar(Carrinho carrinho) {
		try {
			
			CarrinhoEntity carrinhoEntity = new CarrinhoEntity(carrinho);
			
			carrinhoRepository.save(carrinhoEntity);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarBancoDeDadosException();
		}
		
	}

	private Optional<Carrinho> checarSeCarrinhoEstaPresente(Optional<Carrinho> carrinhoOp,
			Optional<CarrinhoEntity> carrinhoEntityOp) {
		if(carrinhoEntityOp.isPresent()) {
			CarrinhoEntity carrinhoEntity = carrinhoEntityOp.get();
			Carrinho carrinhoEncontrado = carrinhoEntity.mapperToDomain();
			carrinhoOp = Optional.of(carrinhoEncontrado);
		}
		return carrinhoOp;
	}

	private void salvarItens(Carrinho carrinho, CarrinhoEntity carrinhoSalvo) {
		if(!carrinho.getItens().isEmpty()) {
			for (Item item : carrinho.getItens()) {
				Long idItem = itemRepository.save(new ItemEntity(item, carrinhoSalvo)).getId();
				item.setId(idItem);
			}
		}
	}
}
