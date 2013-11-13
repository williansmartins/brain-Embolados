package com.williansmartins.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="pedido_jpa")
public class PedidoEntity {

	@Id @GeneratedValue
	Integer id;
	String nome;
	String lanche;
	String bebida;
	
	public PedidoEntity() {
		
	}

	public PedidoEntity(Integer id, String nome, String lanche, String bebida) {
		super();
		this.id = id;
		this.nome = nome;
		this.lanche = lanche;
		this.bebida = bebida;
	}
	
	public PedidoEntity(String nome, String lanche, String bebida) {
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
