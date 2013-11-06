package com.williansmartins.dao;


public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int XML = 2;
	
	private static DAOFactory factory = null;
	
     public abstract PedidoDAO getPedidoDAO();
     //public abstract PedidoDAO getPedidoDAO();//add outro metodo abstract
     
     public static DAOFactory getDAOFactory(int whichFactory){
    	 switch (whichFactory) {
			case MYSQL:
				if(factory == null){
					factory = new PedidoDAOJDBC();
				}break;
			case XML:
				if(factory == null){
					factory = new PedidoDAOJDBC();//trocar por outra Implementacao
				}break;
	
			default: return null;
		}
		return factory;
     }
}