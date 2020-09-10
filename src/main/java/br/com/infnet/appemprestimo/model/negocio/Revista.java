package br.com.infnet.appemprestimo.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TRevista")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Revista extends Produto {

	private String editora;

	@Override
	public String toString() {
		return String.format("%s - %s", super.toString(), this.getEditora());
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
}