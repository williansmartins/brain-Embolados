package com.williansmartins.teste;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.PedidoDaoImpl;
import com.williansmartins.model.PedidoEntity;

public class PedidoTest {
	private PedidoDaoImpl daoEntity = new PedidoDaoImpl();

	@Test
	public void inserirPedido() {
		PedidoEntity pedidoMockado = new PedidoEntity("nayara", "baguete", "vinho");
		pedidoMockado = daoEntity.insert(pedidoMockado);
		PedidoEntity pedidoBuscado = daoEntity.findById(new Long(pedidoMockado.getId()));
		
		Assert.assertEquals(pedidoBuscado.getId(), pedidoMockado.getId());
		Assert.assertEquals(pedidoBuscado.getNome(), pedidoMockado.getNome());
	}
	
//	@Test
//	public void excluirPedido() {
//		PedidoEntity pedidoMockado = new PedidoEntity("nayara", "baguete", "vinho");
//		daoEntity.insert(pedidoMockado);
//		daoEntity.delete(pedidoMockado);
//		PedidoEntity pedidoBanco = daoEntity.findById(pedidoMockado);
//		
//		Assert.assertNull(pedidoBanco);
//	}
//	
//	@Test
//	public void listarPedidos() {
//		PedidoEntity pedidoMockado1 = new PedidoEntity("nome1", "lanche1", "bebida1");
//		PedidoEntity pedidoMockado2 = new PedidoEntity("nome2", "lanche2", "bebida2");
//		daoEntity.insert(pedidoMockado1);
//		daoEntity.insert(pedidoMockado2);
//		List<PedidoEntity> lista = daoEntity.findAll();
//		
//		Assert.assertTrue( lista.size() >1 );
//	}
}
