package br.com.infnet.appemprestimo.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TLivro")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Livro extends Produto {

	private String autor;

	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), this.getAutor());
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
