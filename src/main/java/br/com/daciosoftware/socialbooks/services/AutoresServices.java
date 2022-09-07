package br.com.daciosoftware.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daciosoftware.socialbooks.domain.Autor;
import br.com.daciosoftware.socialbooks.repository.AutoresRepository;

@Service
public class AutoresServices {

	@Autowired
	AutoresRepository autoresRepository;
	
	public List<Autor> lista() {
		return autoresRepository.findAll();
	}
}
