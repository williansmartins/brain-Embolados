package com.williansmartins.teste;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JPADAO;
import com.williansmartins.model.PedidoEntity;

public class PedidoTest {
	JPADAO dao = new JPADAO();

	@Test
	public void inserirPedido() {
		PedidoEntity pedidoMockado = new PedidoEntity("nayara", "baguete", "vinho");
		pedidoMockado = dao.insert(pedidoMockado);
		PedidoEntity pedidoBuscado = dao.findById(pedidoMockado);
		
		Assert.assertEquals(pedidoBuscado.getId(), pedidoMockado.getId());
		Assert.assertEquals(pedidoBuscado.getNome(), pedidoMockado.getNome());
	}
	
	@Test
	public void excluirPedido() {
		PedidoEntity pedidoMockado = new PedidoEntity("nayara", "baguete", "vinho");
		dao.insert(pedidoMockado);
		dao.delete(pedidoMockado);
		PedidoEntity pedidoBanco = dao.findById(pedidoMockado);
		
		Assert.assertNull(pedidoBanco);
	}
	
	@Test
	public void listarPedidos() {
		PedidoEntity pedidoMockado1 = new PedidoEntity("nome1", "lanche1", "bebida1");
		PedidoEntity pedidoMockado2 = new PedidoEntity("nome2", "lanche2", "bebida2");
		dao.insert(pedidoMockado1);
		dao.insert(pedidoMockado2);
		List<PedidoEntity> lista = dao.findAll();
		
		Assert.assertTrue( lista.size() >1 );
	}
}
