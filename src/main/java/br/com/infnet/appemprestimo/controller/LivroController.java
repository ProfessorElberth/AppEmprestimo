package br.com.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appemprestimo.model.negocio.Livro;
import br.com.infnet.appemprestimo.model.service.LivroService;

@Controller
public class LivroController {

	@Autowired private LivroService livroService;
	
	@GetMapping(value = "/livro")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "livro/detalhe";
	}
	
	@GetMapping(value = "/livros")
	public String lista(
				Model model
			) {
		model.addAttribute("livros", livroService.obterLista());
		
		return "livro/lista";
	}
	
	@PostMapping(value = "/livro/incluir")
	public String incluir(
				Livro livro
			) {
		
		livroService.incluir(livro);
		
		return "redirect:/livros";
	}

	@GetMapping(value = "/livro/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			livroService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/livros";
	}
	
	@GetMapping(value = "/livro/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("livro", livroService.obterPorId(id));
		
		return "livro/detalhe";
	}
}