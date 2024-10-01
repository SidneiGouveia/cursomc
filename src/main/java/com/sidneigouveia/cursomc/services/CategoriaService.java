package com.sidneigouveia.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidneigouveia.cursomc.domain.Categoria;
import com.sidneigouveia.cursomc.repositories.CategoriaRepository;
import com.sidneigouveia.cursomc.services.exceptions.ObjectNotFoundException; // Use sua exceção customizada

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
