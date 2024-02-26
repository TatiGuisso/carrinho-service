package com.grupo16.carrinhoservice.gateway.controller.json;

import com.grupo16.carrinhoservice.domain.Item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemJson {
	
	private Long id;
	private Integer quantidade;
	private Double precoUnitario;
	
	public Item mapperToDomain() {
		return Item.builder()
				.id(id)
				.quantidade(quantidade)
				.precoUnitario(precoUnitario)
				.build();
	}
	
	public ItemJson(Item tem) {
		id = tem.getId();
		quantidade = tem.getQuantidade();
		precoUnitario = tem.getPrecoUnitario();
	}

}
