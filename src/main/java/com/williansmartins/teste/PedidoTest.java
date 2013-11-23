package com.williansmartins.teste;

import java.util.ArrayList;
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
		Assert.assertNotNull(obj.getId());
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
		List<PedidoEntity> listaEntities = new ArrayList<PedidoEntity>();
		
		for  (int cont = 0; cont < 10; cont++) {
			PedidoEntity pedidoMockado = new PedidoEntity("nome2", "lanche2", "bebida2");
			listaEntities.add(pedidoMockado);
		}
		
		dao.insertAll(listaEntities);
		
		List<PedidoEntity> lista = dao.findAll();
		
		Assert.assertTrue( lista.size() >1 );
	}
}
