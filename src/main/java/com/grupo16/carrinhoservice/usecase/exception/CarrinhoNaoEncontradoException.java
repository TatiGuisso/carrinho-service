package com.grupo16.carrinhoservice.usecase.exception;

import com.grupo16.carrinhoservice.exception.SystemBaseException;

import lombok.Getter;

@Getter
public class CarrinhoNaoEncontradoException extends SystemBaseException{
	private static final long serialVersionUID = -1738985112058252461L;

	private final String code = "carrinho.arrinhoNaoEncontrado";
	private final String message = "Carrinho não encontrado.";
	private final Integer httpStatus = 404;

}
