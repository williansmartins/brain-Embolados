package com.williansmartins.teste;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.PedidoDAOJDBC;
import com.williansmartins.model.Pedido;

public class PedidoTest {

	@Test
	public void test() {
		Pedido pedidoMockado = new Pedido(null, "willians", "pao", "suco");
		Integer id_mockado = new PedidoDAOJDBC().save(pedidoMockado);
		Pedido pedidoBuscado = new PedidoDAOJDBC().findById(id_mockado);
		
		Assert.assertEquals(id_mockado, pedidoBuscado.getId());
		Assert.assertEquals(pedidoBuscado.getNome(), pedidoMockado.getNome());
		
	}
}
