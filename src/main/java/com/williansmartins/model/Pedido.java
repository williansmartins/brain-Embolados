package com.williansmartins.model;

public class Pedido {
	
	private Integer id;
	private final Produto produto;
	private String nome;
	
	public Pedido(Produto produto) {
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}

	public Produto getProduto() {
		return this.produto;
	}

}
