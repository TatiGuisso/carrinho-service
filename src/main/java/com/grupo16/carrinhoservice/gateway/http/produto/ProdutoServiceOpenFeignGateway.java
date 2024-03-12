package com.grupo16.carrinhoservice.gateway.http.produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grupo16.carrinhoservice.domain.Item;
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
	public List<Item> obterPorId(List<Long> ids) {
	try {
		
		List<Item> itens = new ArrayList<>();
		
		ids.stream().forEach(id -> {
			ProdutoJson produtoJson = produtoServiceFeignClient.obterPorId(id);
			itens.add(Item.builder()
					.idProduto(produtoJson.getId())
					.precoUnitario(produtoJson.getPrecoUnitario())
					.build());
		});
		

		return itens;
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
