package com.grupo16.carrinhoservice.gateway.http.produto;

import org.springframework.stereotype.Component;

import com.grupo16.carrinhoservice.exception.ErrorAoAcessarProdutoServiceException;
import com.grupo16.carrinhoservice.gateway.ProdutoServiceGateway;
import com.grupo16.carrinhoservice.gateway.http.produto.json.ProdutoJson;

import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class ProdutoServiceOpenFeignGateway implements ProdutoServiceGateway {

	private ProdutoServiceFeignClient produtoServiceFeignClient;
	
	@Override
	public ProdutoJson obterPorId(Long id) {
	try {
		
		ProdutoJson produtoJson = produtoServiceFeignClient.obterPorId(id);

		return null;
	} catch (Exception e) {
		log.error(e.getMessage(), e);
		if(e instanceof FeignException feignException) {

			//TODO: implementar
			String exceptionResponseBody = feignException.contentUTF8();
			log.error(exceptionResponseBody);

		}
		throw new ErrorAoAcessarProdutoServiceException();
	}
}

}
