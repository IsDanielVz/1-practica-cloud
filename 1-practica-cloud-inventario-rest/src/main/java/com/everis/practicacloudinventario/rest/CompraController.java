package com.everis.practicacloudinventario.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.practicacloudinventario.model.Compra;
import com.everis.practicacloudinventario.model.Producto;
import com.everis.practicacloudinventario.service.CompraService;
import com.everis.practicacloudinventario.service.ProductoService;

@RestController
@RequestMapping("compras")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ProductoService productoService;
//	
//	@GetMapping("compra/id/5/cantidad/90")
//	public Compra insertar(Compra compra) {
//		Producto producto = compra.getProducto();
//		
//		return compraService.insertar(compra);
//	}
//	
	
	
}
