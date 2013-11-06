package com.williansmartins.teste;

import com.williansmartins.dao.DAOFactory;
import com.williansmartins.dao.PedidoDAO;

public class Negocio {
	public static void main(String[] args) {
		PedidoDAO dao = DAOFactory.getDAOFactory(1).getPedidoDAO();
		System.out.println(dao.findById(3));
	}
}
