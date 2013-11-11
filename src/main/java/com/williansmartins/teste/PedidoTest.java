package com.williansmartins.teste;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.PedidoDAOJDBC;
import com.williansmartins.model.Pedido;

public class PedidoTest {

	@Test
	public void test() {
		Integer id = new PedidoDAOJDBC().save("willians", "pao", "suco", null);
		Pedido pedido = new PedidoDAOJDBC().findById(id);
		
		Assert.assertEquals(id, pedido.getId());
		Assert.assertEquals(pedido.getNome(), "willians");
		
	}
}