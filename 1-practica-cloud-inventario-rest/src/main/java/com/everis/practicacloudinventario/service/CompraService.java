package com.everis.practicacloudinventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.practicacloudinventario.model.Compra;
import com.everis.practicacloudinventario.repository.CompraRepository;

@Service
public class CompraService {
		
	@Autowired 
	private CompraRepository compraRepository;
	
	public Compra insertar(Compra compra) {
		return compraRepository.save(compra);
	}
	
}
