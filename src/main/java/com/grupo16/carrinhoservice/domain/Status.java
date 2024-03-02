package com.grupo16.carrinhoservice.domain;

public enum Status {
	
	ATIVO,
	INATIVO;
	
	public static Status getByOrdinal(int ordinal) {
		Status[] values = values();
		return values[ordinal];
	}

}
