package br.com.infnet.appemprestimo.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appemprestimo.model.negocio.Game;

@Repository
public interface IGameRepository extends CrudRepository<Game, Integer> {

	List<Game> findAll(Sort by);
}
