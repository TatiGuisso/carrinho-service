package com.grupo16.carrinhoservice.gateway.repository.jpa.entity;

import java.util.List;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;
import com.grupo16.carrinhoservice.domain.Status;

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
	private int status;
	
	@OneToMany(mappedBy = "carrinho")
	private List<ItemEntity> itens;
	
	public CarrinhoEntity(Carrinho carrinho) {
		id = carrinho.getId();
		idUsuario = carrinho.getIdUsuario();
		status = carrinho.getStatus().ordinal();
	}
	
	public Carrinho mapperToDomain() {
		List<Item> itensDomain = this.itens.stream().map(ItemEntity::mapperToDomain).toList();
		return Carrinho.builder()
				.id(id)
				.idUsuario(idUsuario)
				.status(Status.getByOrdinal(status))
				.itens(itensDomain)
				.build();
	}

	public Carrinho mapperCarrinhoComItensToDomain(List<ItemEntity> itensEntities) {
		
		List<Item> itensDomain = this.itens.stream().map(ItemEntity::mapperToDomain).toList();
		
		return Carrinho.builder()
				.id(id)
				.idUsuario(idUsuario)
				.status(Status.getByOrdinal(status))
				.itens(itensDomain)
				.build();
	}

}
