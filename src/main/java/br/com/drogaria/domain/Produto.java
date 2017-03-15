package br.com.drogaria.domain;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.GenericDomain;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {

	@Column(nullable = false, length = 80)
	private String descrisao;

	@Column(nullable = false)
	private Short quantidade;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;

	public String getDescrisao() {
		return descrisao;
	}

	public void setDescrisao(String descrisao) {
		this.descrisao = descrisao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	
}
