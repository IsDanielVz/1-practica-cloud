package com.everis.practicacloudinventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudinventario.model.Producto;
import com.everis.practicacloudinventario.repository.ProductoRespository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRespository productoRespository;
	
	public Producto findByNombre(String nombre) {
		return productoRespository.findByNombre(nombre);
	}
}
