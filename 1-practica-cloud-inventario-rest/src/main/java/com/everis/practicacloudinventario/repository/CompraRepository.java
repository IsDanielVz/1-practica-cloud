package com.everis.practicacloudinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicacloudinventario.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
