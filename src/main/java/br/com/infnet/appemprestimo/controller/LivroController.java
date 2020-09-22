package br.com.infnet.appemprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appemprestimo.model.negocio.Livro;
import br.com.infnet.appemprestimo.model.service.LivroService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/emprestimo")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@ApiOperation(value = "Retornar uma lista de livros")
	@GetMapping(value = "/livros")
	public List<Livro> obterLista() {
		return livroService.obterLista();
	}

	@ApiOperation(value = "Retornar um livro")
	@GetMapping(value = "/livro/{id}")
	public Livro obterPorId(@PathVariable Integer id) {
		return livroService.obterPorId(id);
	}

	@ApiOperation(value = "Cadastrar um novo livro")
	@PostMapping(value = "/livro/incluir")
	public void incluir(@RequestBody Livro livro) {
		livroService.incluir(livro);
	}

	@ApiOperation(value = "Remover um livro existente")
	@GetMapping(value = "/livro/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		livroService.excluir(id);
	}
}