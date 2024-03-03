package com.grupo16.carrinhoservice.gateway.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	void deleteByCarrinhoId(Long id);

	List<ItemEntity> findAllByCarrinhoId(Long id);

}
