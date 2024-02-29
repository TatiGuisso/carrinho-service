package com.grupo16.carrinhoservice.gateway.repository.mysql;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;
import com.grupo16.carrinhoservice.gateway.exception.ErroAoAcessarBancoDeDadosException;
import com.grupo16.carrinhoservice.gateway.repository.jpa.CarrinhoRepository;
import com.grupo16.carrinhoservice.gateway.repository.jpa.ItemRepository;
import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.CarrinhoEntity;
import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.ItemEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CarrinhoMySqlGateway implements CarrinhoRepositoryGateway {
	
	private CarrinhoRepository carrinhoRepository;
	
	private ItemRepository itemRepository;

	@Override
	@Transactional
	public Long salvar(Carrinho carrinho) {
		
		try {
			CarrinhoEntity carrinhoEntity = new CarrinhoEntity(carrinho);
			CarrinhoEntity carrinhoSalvo = carrinhoRepository.save(carrinhoEntity);
			
			if(!carrinho.getItens().isEmpty()) {
				for (Item item : carrinho.getItens()) {
					Long idItem = itemRepository.save(new ItemEntity(item, carrinhoSalvo)).getId();
					item.setId(idItem);
				}
			}
			
			return carrinhoSalvo.getId();
			
		} catch (Exception e) {
			throw new ErroAoAcessarBancoDeDadosException();
		}
		
	}
	

}
