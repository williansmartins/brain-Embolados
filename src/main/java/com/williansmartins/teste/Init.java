package com.williansmartins.teste;

import com.williansmartins.dao.PedidoDAOJDBC;

//import com.williansmartins.dao.DAOFactory;
//import com.williansmartins.dao.PedidoDAO;

public class Init {
	public static void main(String[] args) {
		new PedidoDAOJDBC().init();
	}
}
