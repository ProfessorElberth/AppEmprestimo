package br.com.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.appemprestimo.model.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired private ProdutoService produtoService;
	
	@GetMapping(value = "/produtos")
	public String lista(
				Model model
			) {
		model.addAttribute("produtos", produtoService.obterLista());
		
		return "produto/lista";
	}

	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			produtoService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/produtos";
	}
}