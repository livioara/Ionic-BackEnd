package com.livio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livio.cursomc.domain.Categoria;
import com.livio.cursomc.repositories.CategoriaRepository;
import com.livio.cursomc.services.exceptions.ObjectNotFoundException;

import net.bytebuddy.asm.Advice.Return;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
		
	}

	
}

