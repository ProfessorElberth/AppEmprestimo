package br.com.infnet.appemprestimo.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String nome;
	private String login;
	private String senha;
	
	public Usuario() {		
	}
	
	public Usuario(String login, String senha) {
		this();
		this.setNome(login.toUpperCase());
		this.setLogin(login);
		this.setSenha(senha);
	}

	public Usuario(Integer id, String nome, String login, String senha) {
		this(login, senha);
		this.setId(id);
		this.setNome(nome);
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s",
					this.nome,
					this.login,
					this.senha
				);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}