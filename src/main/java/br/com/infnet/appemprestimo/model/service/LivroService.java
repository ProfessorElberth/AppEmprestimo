package br.com.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appemprestimo.model.negocio.Livro;
import br.com.infnet.appemprestimo.model.repository.ILivroRepository;

@Service
public class LivroService {

	@Autowired private ILivroRepository livroRepository;
	
	public List<Livro> obterLista(){
		return (List<Livro>)livroRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void incluir(Livro livro) {
		livroRepository.save(livro);
	}

	public void excluir(Integer id) {
		livroRepository.deleteById(id);		
	}

	public Livro obterPorId(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}
}