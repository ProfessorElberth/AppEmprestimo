package br.com.infnet.appemprestimo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.infnet.appemprestimo.model.negocio.Game;
import br.com.infnet.appemprestimo.model.repository.IGameRepository;

@Service
public class GameService {

	@Autowired private IGameRepository gameRepository;
	
	public List<Game> obterLista(){
		return (List<Game>)gameRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
	}
	
	public void incluir(Game game) {
		gameRepository.save(game);
	}

	public void excluir(Integer id) {
		gameRepository.deleteById(id);		
	}

	public Game obterPorId(Integer id) {
		return gameRepository.findById(id).orElse(null);
	}
}