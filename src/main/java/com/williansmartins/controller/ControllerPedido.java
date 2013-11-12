package com.williansmartins.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.PedidoDAOJDBC;
import com.williansmartins.model.Pedido;

@ManagedBean(name="pedidos")
@SessionScoped
public class ControllerPedido {
	
	private Pedido pedido;
	
	public ControllerPedido(){
		pedido = new Pedido();
	}
	
	public String home(){
		pedido = new Pedido();
		return "index.xhtml?faces-redirect=true";
	}
	
	public String list(){
		pedido = new Pedido();
		return "lista.xhtml?faces-redirect=true";
	}
	
	public String save(){
		new PedidoDAOJDBC().save(pedido);
		pedido = new Pedido();
		return "lista.xhtml";
	}
	
	public String remove(){
		new PedidoDAOJDBC().remove(pedido.getId());
		return "lista.xhtml";
	}	
	
	public String incAlt(){
		pedido = new PedidoDAOJDBC().findById(pedido.getId());
		return "inserir.xhtml";
	}	
	
	public String prepareInsert(){
		pedido = new Pedido();
		System.out.println("insert");
		return "inserir.xhtml?faces-redirect=true";
	}	
	
	public List<Pedido> getPedidoList() {
		return new PedidoDAOJDBC().findAll();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
