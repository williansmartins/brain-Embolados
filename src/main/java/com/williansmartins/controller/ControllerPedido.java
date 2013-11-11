package com.williansmartins.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.PedidoDAOJDBC;

@ManagedBean
@SessionScoped
public class ControllerPedido {
	
	private String nome;
	private String lanche;
	private String bebida;
	
	public ControllerPedido(){
	}
	
	public void enviar(){
		new PedidoDAOJDBC().save(nome, lanche, bebida, null);
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
