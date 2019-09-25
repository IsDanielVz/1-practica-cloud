package com.everis.practicacloudcompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicacloudcompra.model.Producto;

@Repository
public interface ProductoRespository extends JpaRepository<Producto, Integer> {

	Producto findByNombre(String nombre);
	
}
