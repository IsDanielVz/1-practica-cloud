package com.everis.practicacloudcompra.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.practicacloudcompra.model.responses.CompraResponses;

@FeignClient(name = "PRACTICA-CLOUD-INVENTARIO-REST")
@RibbonClient(name = "PRACTICA-CLOUD-INVENTARIO-REST")
public interface CompraServiceProxy {
	
	@GetMapping("/inventario/id/{id}/")
	public CompraResponses retrieveProducto(@PathVariable int id);
}
