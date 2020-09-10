package br.com.infnet.appemprestimo.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appemprestimo.model.negocio.Usuario;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	@Query("from Usuario u where u.login =:login and u.senha =:senha")
	Usuario autenticacao(String login, String senha);
	
	Usuario findByLogin(String login);
}