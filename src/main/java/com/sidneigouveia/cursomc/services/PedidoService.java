package com.sidneigouveia.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidneigouveia.cursomc.domain.Pedido;
import com.sidneigouveia.cursomc.repositories.PedidoRepository;
import com.sidneigouveia.cursomc.services.exceptions.ObjectNotFoundException; // Use sua exceção customizada

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
