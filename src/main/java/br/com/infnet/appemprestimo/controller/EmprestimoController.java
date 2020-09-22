package br.com.infnet.appemprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appemprestimo.model.negocio.Emprestimo;
import br.com.infnet.appemprestimo.model.service.EmprestimoService;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;

	@GetMapping(value = "/lista")
	public List<Emprestimo> obterLista() {
		return emprestimoService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestParam Emprestimo emprestimo) {
		emprestimoService.incluir(emprestimo);
	}

	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		emprestimoService.excluir(id);
	}

	@GetMapping(value = "/{id}/consultar")
	public Emprestimo consultar(@PathVariable Integer id) {
		return emprestimoService.obterPorId(id);
	}
}