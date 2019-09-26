package com.everis.practicacloudcompra.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.practicacloudcompra.model.Compra;
import com.everis.practicacloudcompra.model.Mensaje;
import com.everis.practicacloudcompra.model.Producto;
import com.everis.practicacloudcompra.model.ReordenModel;
import com.everis.practicacloudcompra.model.responses.CompraResponses;
import com.everis.practicacloudcompra.model.responses.MensajeResponses;
import com.everis.practicacloudcompra.proxy.CompraServiceProxy;
import com.everis.practicacloudcompra.service.CompraService;
import com.everis.practicacloudcompra.service.ProductoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CompraController {
	@Autowired
	CompraServiceProxy compraServiceProxy;
	@Autowired
	private ReordenModel reordenModel;
	@GetMapping("/compra")
	public String reorden() {
		return reordenModel.getReorden()+"";
	}	
	
	@Autowired 
	private CompraService compraService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/compra/id/{id}/cantidad/{cantidad}")
	public CompraResponses comprar(@PathVariable int id, @PathVariable int cantidad) {
		MensajeResponses exito;
//		String url = "http://192.168.1.73:8000/inventario/id/{id}";
		CompraResponses compraResponses = new CompraResponses();
//		Map<String, Long> uriVariables = new HashMap<>();
//		uriVariables.put("id", id);
		try {
//			ResponseEntity<CompraResponses> respuesta = new RestTemplate().getForEntity(url, CompraResponses.class, uriVariables);
//			compraResponses = respuesta.getBody();
			compraResponses = compraServiceProxy.retrieveProducto(id);
			Producto encontrado = compraResponses.getProducto();
			int stock = compraResponses.getProducto().getStock();
			Mensaje mensaje = new Mensaje();
			if(stock == 0 ) {
				String url = "https://whatzmeapi.com:10501/rest/api/enviar-mensaje?token="+mensaje.getToken();
				RestTemplate restTemplate = new RestTemplate();
				mensaje.setMensaje("Inventario vacío, reabastecer porfavor");
				mensaje.setNumero("525548124063");
				
				String respuesta = new RestTemplate().postForObject(url, mensaje, String.class);
				
				ObjectMapper objectMapper = new ObjectMapper();
				exito = objectMapper.readValue(respuesta, new TypeReference<MensajeResponses>() {
				});
				
				
				
			}
			int nuevoStoc = stock-cantidad;
			int ventaMaxima = stock - (stock* reordenModel.getReorden()/100);
			//System.out.println(stock+", "+ ventaMaxima + ","+cantidad+", " + reordenModel.getReorden());
			//if(cantidad <= ventaMaxima ) {
			if(cantidad <= stock) {
					compraResponses.setExito(true);
					compraResponses.setMensaje("Si hay productos suficientes");
					encontrado.setStock(nuevoStoc);
					Compra nuevaCompra = new Compra();
					nuevaCompra.setCantidad(cantidad);
					nuevaCompra.setProducto(encontrado);
					nuevaCompra.setFechahora(new Date());
					productoService.actualizarStock(encontrado);
					compraService.insertar(nuevaCompra);
					
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
