package com.williansmartins.model;

import java.math.BigDecimal;

public class Produto {

	private final String descricao;
	private final BigDecimal preco;
	private final int quantidade;

	public Produto(String descricao, BigDecimal preco, int quantidade) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}


}
