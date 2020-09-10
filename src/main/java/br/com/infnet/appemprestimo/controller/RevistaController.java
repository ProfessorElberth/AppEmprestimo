package br.com.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appemprestimo.model.negocio.Revista;
import br.com.infnet.appemprestimo.model.service.RevistaService;

@Controller
public class RevistaController {

	@Autowired private RevistaService revistaService;
	
	@GetMapping(value = "/revista")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "revista/detalhe";
	}
	
	@GetMapping(value = "/revistas")
	public String lista(
				Model model
			) {
		model.addAttribute("revistas", revistaService.obterLista());
		
		return "revista/lista";
	}
	
	@PostMapping(value = "/revista/incluir")
	public String incluir(
				Revista revista
			) {
		
		revistaService.incluir(revista);
		
		return "redirect:/revistas";
	}

	@GetMapping(value = "/revista/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			revistaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/revistas";
	}
	
	@GetMapping(value = "/revista/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("revista", revistaService.obterPorId(id));
		
		return "revista/detalhe";
	}
}