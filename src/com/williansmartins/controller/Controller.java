package com.williansmartins.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.DAOFactory;
import com.williansmartins.dao.PedidoDAO;
import com.williansmartins.model.Pedido;

@ManagedBean
@SessionScoped
public class Controller {
	

	private Pedido pedido;
	private String titulo;
	
	public Controller() {
		pedido = new Pedido();
	}

	public String enviar(){
		PedidoDAO dao = DAOFactory.getDAOFactory(1).getPedidoDAO();
		dao.save(pedido);
		return null;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
