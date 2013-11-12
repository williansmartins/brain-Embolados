package com.williansmartins.model;

public class Pedido {

	Integer id;
	String nome;
	String lanche;
	String bebida;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, String nome, String lanche, String bebida) {
		super();
		this.id = id;
		this.nome = nome;
		this.lanche = lanche;
		this.bebida = bebida;
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

	public String getLanche() {
		return lanche;
	}

	public void setLanche(String lanche) {
		this.lanche = lanche;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

}
