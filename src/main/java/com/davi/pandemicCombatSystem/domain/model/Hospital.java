package com.davi.pandemicCombatSystem.domain.model;

import java.util.ArrayList;

public class Hospital {
	
	private String nome;
	private Endereco endereco;
	private String cnpj;
	private Localizacao localizacao;
	private ArrayList<Recurso> recursos;
	private float percentualDeOcupacao;
	public static final int OCUPACAO_EXCESSIVA = 90;
	
	public Hospital(String nome, String cnpj, float latitude, float longitude,
			String cidade, String rua, int numero, ArrayList<Recurso> recursos,float percentualDeOcupacao) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.localizacao = new Localizacao(latitude, longitude);
		this.endereco = new Endereco(cidade, rua, numero);
		this.percentualDeOcupacao = percentualDeOcupacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}

	public float getPercentualDeOcupacao() {
		return percentualDeOcupacao;
	}

	public void setPercentualDeOcupacao(float percentualDeOcupacao) {
		this.percentualDeOcupacao = percentualDeOcupacao;
	}
	
	
}
