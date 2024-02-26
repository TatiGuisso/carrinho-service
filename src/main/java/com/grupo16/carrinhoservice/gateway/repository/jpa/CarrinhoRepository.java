package com.grupo16.carrinhoservice.gateway.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.CarrinhoEntity;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long>{

}
