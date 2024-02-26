package com.grupo16.carrinhoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	private Long id;
	private Integer quantidade;
	
	@Setter
	private Double precoUnitario;
	
	public Double getPrecoTotal() {
		return precoUnitario * quantidade;
	}

}
