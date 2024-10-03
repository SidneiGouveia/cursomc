package com.sidneigouveia.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidneigouveia.cursomc.domain.ItemPedido;

import jakarta.persistence.Id;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido , Id> {
	
	

}
