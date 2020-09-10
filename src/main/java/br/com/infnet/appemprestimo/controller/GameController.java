package br.com.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appemprestimo.model.negocio.Game;
import br.com.infnet.appemprestimo.model.service.GameService;

@Controller
public class GameController {

	@Autowired private GameService gameService;
	
	@GetMapping(value = "/game")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "game/detalhe";
	}
	
	@GetMapping(value = "/games")
	public String lista(
				Model model
			) {
		model.addAttribute("games", gameService.obterLista());
		
		return "game/lista";
	}
	
	@PostMapping(value = "/game/incluir")
	public String incluir(
				Game game
			) {
		
		gameService.incluir(game);
		
		return "redirect:/games";
	}

	@GetMapping(value = "/game/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			gameService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/games";
	}
	
	@GetMapping(value = "/game/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("game", gameService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "game/detalhe";
	}
}