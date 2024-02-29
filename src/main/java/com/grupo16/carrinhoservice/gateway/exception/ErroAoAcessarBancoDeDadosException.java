package com.grupo16.carrinhoservice.gateway.exception;

import com.grupo16.carrinhoservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class ErroAoAcessarBancoDeDadosException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "carrinho.erroAoAcessarBancoDeDados";
	private final String message = "Ocorreu um erro ao acessar o banco de dados.";
	private final Integer httpStatus = 500;

}
