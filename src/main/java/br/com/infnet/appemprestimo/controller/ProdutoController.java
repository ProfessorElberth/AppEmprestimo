package br.com.infnet.appemprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appemprestimo.model.negocio.Produto;
import br.com.infnet.appemprestimo.model.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/emprestimo")
public class ProdutoController {

	@Autowired private ProdutoService produtoService;
	
	@ApiOperation(value = "Retornar uma lista de produtos")
	@GetMapping(value = "/produtos")
	public List<Produto> obterLista() {
		return produtoService.obterLista();
	}
	@ApiOperation(value = "Remover um produto existente")
	@GetMapping(value = "/produto/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
	}
}