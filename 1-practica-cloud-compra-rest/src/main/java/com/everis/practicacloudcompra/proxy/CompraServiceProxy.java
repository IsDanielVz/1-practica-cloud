package com.everis.practicacloudcompra.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.practicacloudcompra.model.responses.CompraResponses;

@FeignClient(name = "producto-service")
@RibbonClient(name = "producto-service")
public interface CompraServiceProxy {
	
	@GetMapping("/compra/id/{id}/")
	public CompraResponses retrieveProducto(@PathVariable Long id);
}