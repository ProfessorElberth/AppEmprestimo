package br.com.infnet.appemprestimo.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appemprestimo.model.negocio.Livro;

@Repository
public interface ILivroRepository extends CrudRepository<Livro, Integer> {

	List<Livro> findAll(Sort by);
}
