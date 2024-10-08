package com.sidneigouveia.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidneigouveia.cursomc.domain.Cliente;
import com.sidneigouveia.cursomc.repositories.ClienteRepository;
import com.sidneigouveia.cursomc.services.exceptions.ObjectNotFoundException; // Use sua exceção customizada

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
