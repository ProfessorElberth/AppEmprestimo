package br.com.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appemprestimo.model.negocio.Solicitante;
import br.com.infnet.appemprestimo.model.service.SolicitanteService;

@Controller
public class SolicitanteController {

	@Autowired private SolicitanteService solicitanteService;
	
	@GetMapping(value = "/solicitante")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		
		return "solicitante/detalhe";
	}
	
	@GetMapping(value = "/solicitantes")
	public String lista(
				Model model
			) {
		model.addAttribute("solicitantes", solicitanteService.obterLista()); 
		
		return "solicitante/lista";
	}
	
	@PostMapping(value = "/solicitante/incluir")
	public String incluir(
				Solicitante solicitante
			) {
		
		solicitanteService.incluir(solicitante);
		
		return "redirect:/solicitantes";
	}
	
	@GetMapping(value = "/solicitante/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			solicitanteService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/solicitantes";
	}
	
	@GetMapping(value = "/solicitante/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("solicitante", solicitanteService.obterPorId(id));
		
		return "solicitante/detalhe";
	}
}
