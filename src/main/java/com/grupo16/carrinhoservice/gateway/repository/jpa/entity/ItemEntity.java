package com.grupo16.carrinhoservice.gateway.repository.jpa.entity;

import com.grupo16.carrinhoservice.domain.Carrinho;
import com.grupo16.carrinhoservice.domain.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Item")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idProduto;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="idCarrinho")
	private CarrinhoEntity carrinho;
	
	public ItemEntity(Item item, CarrinhoEntity carrinhoEntity) {
		id = item.getId();
		idProduto = item.getIdProduto();
		quantidade = item.getQuantidade();
		carrinho = carrinhoEntity;
	}
	
	public Item mapperToDomain() {
		return Item.builder()
				.id(id)
				.idProduto(idProduto)
				.quantidade(quantidade)
				.carrinho(Carrinho.builder()
						.id(carrinho.getId())
						.build())
				.build();
	}
	
}
