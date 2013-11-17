package com.williansmartins.teste;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.PedidoDaoImpl;
import com.williansmartins.model.PedidoEntity;

public class PedidoTest {
	JpaGenericDao<PedidoEntity> dao = new PedidoDaoImpl();
	
	@Test
	public void inserirObjeto() {
		PedidoEntity obj = new PedidoEntity("luis", "Xis-salada", "suquinho-saude");
		
		dao.insert(obj);
		PedidoEntity obj2 = dao.findById(obj.getId());
		
		Assert.assertEquals(obj.getId(), obj2.getId());
		dao.delete(obj2.getId());
	}
	
	@Test
	public void excluirPedido() {
		PedidoEntity pedidoMockado = new PedidoEntity("nayara", "baguete", "vinho");
		dao.insert(pedidoMockado);
		dao.delete(pedidoMockado.getId());
		PedidoEntity pedidoBanco = dao.findById(pedidoMockado.getId());
		
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
