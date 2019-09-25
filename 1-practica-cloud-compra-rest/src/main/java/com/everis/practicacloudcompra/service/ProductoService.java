package com.everis.practicacloudcompra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudcompra.model.Producto;
import com.everis.practicacloudcompra.repository.ProductoRespository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRespository productoRespository;
	
	public Producto findByNombre(String nombre) {
		return productoRespository.findByNombre(nombre);
	}
	
	public Producto findById(int id) {
		return productoRespository.findById(id).get();
	}
	
	public Producto actualizarStock(Producto producto) {
		return productoRespository.save(producto);
	}
}
