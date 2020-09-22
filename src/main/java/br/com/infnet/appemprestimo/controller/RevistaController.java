package br.com.infnet.appemprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.appemprestimo.model.negocio.Revista;
import br.com.infnet.appemprestimo.model.service.RevistaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/emprestimo")
public class RevistaController {

	@Autowired private RevistaService revistaService;
	
	@ApiOperation(value = "Retornar uma lista de revistas")
	@GetMapping(value = "/revistas")
	public List<Revista> obterLista() {
		return revistaService.obterLista();
	}

	@ApiOperation(value = "Retornar uma revista")
	@GetMapping(value = "/revista/{id}")
	public Revista obterPorId(@PathVariable Integer id) {
		return revistaService.obterPorId(id);
	}

	@ApiOperation(value = "Cadastrar uma nova revista")
	@PostMapping(value = "/revista/incluir")
	public void incluir(@RequestBody Revista revista) {
		revistaService.incluir(revista);
	}

	@ApiOperation(value = "Remover uma revista existente")
	@GetMapping(value = "/revista/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		revistaService.excluir(id);
	}
}