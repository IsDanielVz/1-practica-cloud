package com.everis.practicacloudcompra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudcompra.model.Compra;
import com.everis.practicacloudcompra.repository.CompraRepository;

@Service
public class CompraService {
		
	@Autowired 
	private CompraRepository compraRepository;
	
	public Compra insertar(Compra compra) {
		return compraRepository.save(compra);
	}
	
}
