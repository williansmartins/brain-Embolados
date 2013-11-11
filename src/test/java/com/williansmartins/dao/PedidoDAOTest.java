package com.williansmartins.dao;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.williansmartins.model.Pedido;
import com.williansmartins.model.Produto;



public class PedidoDAOTest {

	private PedidoDAO dao;

	@Before
	public void init(){
		dao = new PedidoDAO(ConnectionManager.getConnection());
	}
	
	@Test
	public void deveInserirNoBancoUmPedidoComUmProduto() {
		Pedido pedido = new Pedido(new Produto("coca", new BigDecimal(2.50), 1));
		pedido.setNome("Willians");
		dao.inserir(pedido);
		pedido = dao.buscar(pedido);
		Assert.assertNotNull(pedido);
		Assert.assertNotNull(pedido.getProduto());
	}
	
	@After
	public void finish(){
		dao.close();
	}
	

}
