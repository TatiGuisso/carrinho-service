package com.grupo16.carrinhoservice.gateway.repository.mysql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.gateway.CarrinhoRepositoryGateway;
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
	public Long salvar(Carrinho carrinho) {
		
		CarrinhoEntity carrinhoEntity = new CarrinhoEntity(carrinho);
		CarrinhoEntity carrinhoSalvo = carrinhoRepository.save(carrinhoEntity);
		
		if(!carrinho.getItens().isEmpty()) {
			List<ItemEntity> itensEntity = new ArrayList<>();
			for (Item item : carrinho.getItens()) {
				itensEntity.add(new ItemEntity(item, carrinhoSalvo));
			}
			
			itemRepository.saveAll(itensEntity);
			
		}
		
		return carrinhoSalvo.getId();
	}
	

}
