package com.grupo16.carrinhoservice.gateway.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo16.carrinhoservice.gateway.repository.jpa.entity.CarrinhoEntity;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long>{

	Optional<CarrinhoEntity> findByIdAndIdUsuario(Long id, Long idUsuario);

	Optional<CarrinhoEntity> findByIdAndStatus(Long idUsuario, Integer status);

}
