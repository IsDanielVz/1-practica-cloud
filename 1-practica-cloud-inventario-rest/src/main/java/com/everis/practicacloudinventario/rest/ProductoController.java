package com.everis.practicacloudinventario.rest;

import java.awt.peer.CanvasPeer;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudinventario.model.Compra;
import com.everis.practicacloudinventario.model.Producto;
import com.everis.practicacloudinventario.responses.ProductoResponse;
import com.everis.practicacloudinventario.service.CompraService;
import com.everis.practicacloudinventario.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/inventario/id/{id}")
	public ProductoResponse consultar(@PathVariable int id) {
		ProductoResponse response = new ProductoResponse();
		try {
			Producto valor = productoService.findById(id);
			if(valor == null) {
				response.setExito(false);
				response.setMensaje("Producto no encontrado");
				return response;
			} 
			valor.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			response.setExito(true);
			response.setMensaje("Producto recuperado exitosamente");
			response.setProducto(valor);
		}catch(Exception e) {
			response.setExito(false);
			response.setMensaje(e.getMessage());
		}
		return response;
	} 
	
}
