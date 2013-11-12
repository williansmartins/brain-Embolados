package com.williansmartins.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.PedidoDAOJDBC;
import com.williansmartins.model.Pedido;

@ManagedBean(name="pedidos")
@SessionScoped
public class ControllerPedido {
	
	private String nome;
	private String lanche;
	private String bebida;
	
	public ControllerPedido(){
		
	}
	
	public String save(){
		new PedidoDAOJDBC().save(nome, lanche, bebida, null);
		return "lista.xhtml";
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

	public List<Pedido> getPedidoList() {
		return new PedidoDAOJDBC().findAll();
	}
	
}
