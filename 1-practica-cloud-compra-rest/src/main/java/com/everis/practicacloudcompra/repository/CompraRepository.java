package com.everis.practicacloudcompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicacloudcompra.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
