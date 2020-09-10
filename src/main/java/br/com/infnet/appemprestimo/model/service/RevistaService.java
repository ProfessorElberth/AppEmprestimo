package br.com.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appemprestimo.model.negocio.Revista;
import br.com.infnet.appemprestimo.model.repository.IRevistaRepository;

@Service
public class RevistaService {

	@Autowired private IRevistaRepository revistaRepository;
	
	public List<Revista> obterLista(){
		return (List<Revista>)revistaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void incluir(Revista revista) {
		revistaRepository.save(revista);
	}

	public void excluir(Integer id) {
		revistaRepository.deleteById(id);		
	}

	public Revista obterPorId(Integer id) {
		return revistaRepository.findById(id).orElse(null);
	}
}