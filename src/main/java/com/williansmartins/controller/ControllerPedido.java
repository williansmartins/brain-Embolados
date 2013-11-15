package com.williansmartins.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.williansmartins.dao.PedidoDaoImpl;
import com.williansmartins.model.PedidoEntity;

@ManagedBean(name="pedidos")
@SessionScoped
public class ControllerPedido {
	
	private PedidoEntity pedido;
	private PedidoDaoImpl daoEntity = new PedidoDaoImpl();
	
	public ControllerPedido(){
		pedido = new PedidoEntity();
	}
	
	public String home(){
		pedido = new PedidoEntity();
		return "index.xhtml?faces-redirect=true";
	}
	
	public String list(){
		pedido = new PedidoEntity();
		return "lista.xhtml?faces-redirect=true";
	}
	
	public String save(){
		daoEntity.insert(pedido);
		pedido = new PedidoEntity();
		return "lista.xhtml";
	}
	
	public String remove(){
//		daoEntity.delete(pedido);
		return "lista.xhtml";
	}	
	
	public String incAlt(){
//		pedido = daoEntity.findById(pedido);
		return "inserir.xhtml";
	}	
	
	public String prepareInsert(){
		pedido = new PedidoEntity();
		System.out.println("insert");
		return "inserir.xhtml?faces-redirect=true";
	}	
	
	public List<PedidoEntity> getPedidoList() {
		return daoEntity.findAll();
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}
	
	
}
