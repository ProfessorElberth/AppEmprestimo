package br.com.infnet.appemprestimo.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TGame")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Game extends Produto {

	private Float valor;
	
	@Override
	public String toString() {
		return String.format("%s - %.2f", super.toString(), this.getValor());
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}
