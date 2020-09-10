package br.com.infnet.appemprestimo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.infnet.appemprestimo.model.negocio.Emprestimo;
import br.com.infnet.appemprestimo.model.negocio.Produto;
import br.com.infnet.appemprestimo.model.service.EmprestimoService;
import br.com.infnet.appemprestimo.model.service.ProdutoService;
import br.com.infnet.appemprestimo.model.service.SolicitanteService;

@Controller
public class EmprestimoController {

	@Autowired private ProdutoService produtoService;
	@Autowired private EmprestimoService emprestimoService;
	@Autowired private SolicitanteService solicitanteService;

	@GetMapping(value = "/emprestimo")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "inclusão");
		model.addAttribute("produtos", produtoService.obterLista());
		model.addAttribute("solicitantes", solicitanteService.obterLista());
		
		return "emprestimo/detalhe";
	}

	@GetMapping(value = "/emprestimos")
	public String lista(
				Model model
			) {
		model.addAttribute("emprestimos", emprestimoService.obterLista());
		
		return "emprestimo/lista";
	}
	
	@PostMapping(value = "/emprestimo/incluir")
	public String incluir(
				Model model,
				@RequestParam String[] produtosIds,
				Emprestimo emprestimo
			) {
		
		List<Produto> lista = new ArrayList<Produto>();
		
		for(String id : produtosIds) {
			lista.add(new Produto(Integer.valueOf(id)));
		}
		
		emprestimo.setProdutos(lista);
		
		emprestimoService.incluir(emprestimo);

		return "redirect:/emprestimos";
	}
	
	@GetMapping(value = "/emprestimo/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			emprestimoService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/emprestimos";
	}
	@GetMapping(value = "/emprestimo/{id}/consultar")
	public String consultar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "consulta");
		
		model.addAttribute("emprestimo", emprestimoService.obterPorId(id));
		
		return "emprestimo/consulta";
	}
}
