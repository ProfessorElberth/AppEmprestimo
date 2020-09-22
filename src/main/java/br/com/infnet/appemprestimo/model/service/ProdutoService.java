package br.com.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appemprestimo.model.negocio.Produto;
import br.com.infnet.appemprestimo.model.repository.IProdutoRepository;

@Service
public class ProdutoService {

	@Autowired private IProdutoRepository produtoRepository;
	
	public List<Produto> obterLista(){		
		return (List<Produto>)produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
}