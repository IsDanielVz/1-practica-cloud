package com.everis.practicacloudcompra.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicacloudcompra.model.ReordenModel;
import com.everis.practicacloudcompra.model.responses.CompraResponses;

@RestController
public class CompraController {
	
	@Autowired
	private ReordenModel reordenModel;
	@GetMapping("/compra")
	public String reorden() {
		return reordenModel.getReorden()+"";
	}	
	
	@GetMapping("/compra/id/{id}/cantidad/{cantidad}")
	public CompraResponses comprar(@PathVariable Long id, @PathVariable int cantidad) {
		String url = "http://localhost:8000/inventario/id/{id}";
		CompraResponses compraResponses = new CompraResponses();
		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		try {
			ResponseEntity<CompraResponses> respuesta = new RestTemplate().getForEntity(url, CompraResponses.class, uriVariables);
			compraResponses = respuesta.getBody();
			Long stock = compraResponses.getProducto().getStock();
			Long ventaMaxima = stock - (stock* reordenModel.getReorden()/100);
			//System.out.println(stock+", "+ ventaMaxima + ","+cantidad+", " + reordenModel.getReorden());
			if(cantidad <= ventaMaxima ) {
					
					compraResponses.setExito(true);
					compraResponses.setMensaje("Si hay productos suficientes");
				
			}else {
				compraResponses.setExito(false);
				compraResponses.setMensaje("No hay productos suficientes");
			}	
		}catch(Exception e) {
			compraResponses.setExito(false);
			compraResponses.setMensaje(e.getMessage());
		}
		return compraResponses;
	}
}
