package com.grupo16.carrinhoservice.gateway.repository.jpa.entity;

import java.util.List;

import com.grupo16.carrinhoservice.domain.Carrinho;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Carrinho")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idUsuario;
	
	@OneToMany(mappedBy = "carrinho")
	private List<ItemEntity> itens;
	
	public CarrinhoEntity(Carrinho carrinho) {
		id = carrinho.getId();
		idUsuario = carrinho.getIdUsuario();
	}
	
	public Carrinho mapperToDomain() {
		return Carrinho.builder()
				.id(id)
				.idUsuario(idUsuario)
				.build();
	}

}
