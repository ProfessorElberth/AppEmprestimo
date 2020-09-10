package br.com.infnet.appemprestimo.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appemprestimo.model.negocio.Revista;

@Repository
public interface IRevistaRepository extends CrudRepository<Revista, Integer> {

	List<Revista> findAll(Sort by);
}
