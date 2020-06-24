package br.com.nataliatech.app.model;

import java.util.ArrayList;
import java.util.List;

public class Imovel {
	
	private Integer id;
	private String titulo;
	private Integer qtdade_quarto;
	private boolean suite;
	private Integer metragem;
	private float preco;
	private boolean condominio;
	private Integer vagas;
	private String inf_adicional;
	private String descricao;
	
	private List<Endereco> enderecos = new ArrayList<>();
	

	
	public Imovel(){
		
	}
	
	public Imovel(Integer id, String titulo, Integer qtdade_quarto,
			boolean suite, Integer metragem, float preco, boolean condominio,
			Integer vagas, String inf_adicional, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.qtdade_quarto = qtdade_quarto;
		this.suite = suite;
		this.metragem = metragem;
		this.preco = preco;
		this.condominio = condominio;
		this.vagas = vagas;
		this.inf_adicional = inf_adicional;
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getQtdade_quarto() {
		return qtdade_quarto;
	}
	public void setQtdade_quarto(Integer qtdade_quarto) {
		this.qtdade_quarto = qtdade_quarto;
	}
	public boolean isSuite() {
		return suite;
	}
	public void setSuite(boolean suite) {
		this.suite = suite;
	}
	public Integer getMetragem() {
		return metragem;
	}
	public void setMetragem(Integer metragem) {
		this.metragem = metragem;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isCondominio() {
		return condominio;
	}
	public void setCondominio(boolean condominio) {
		this.condominio = condominio;
	}
	public Integer getVagas() {
		return vagas;
	}
	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}
	public String getInf_adicional() {
		return inf_adicional;
	}
	public void setInf_adicional(String inf_adicional) {
		this.inf_adicional = inf_adicional;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
