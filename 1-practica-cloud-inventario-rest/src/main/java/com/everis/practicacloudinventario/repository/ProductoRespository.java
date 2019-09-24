package com.everis.practicacloudinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicacloudinventario.model.Producto;

@Repository
public interface ProductoRespository extends JpaRepository<Producto, Long> {

	Producto findByNombre(String nombre);
	
}
