package br.com.infnet.appemprestimo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.infnet.appemprestimo.model.negocio.Usuario;
import br.com.infnet.appemprestimo.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired 
	private UsuarioService usuarioService;

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String incluir(
				Model model,
				Usuario usuario
			) {
		
		usuarioService.incluir(usuario);
		
		return "login";
	}	
}