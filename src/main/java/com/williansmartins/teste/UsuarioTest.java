package com.williansmartins.teste;

import org.junit.Test;

import com.williansmartins.dao.JpaGenericDao;
import com.williansmartins.dao.UsuarioDaoImpl;
import com.williansmartins.model.Usuario;

public class UsuarioTest {
	JpaGenericDao<Usuario> dao = new UsuarioDaoImpl();

	@Test
	public void listarObjetos() {
		for (Usuario item : dao.findAll()) {
			System.out.println(">>" + item.getUsuario());
		}
	}
	public void inserirObjeto() {
		System.out.println("Metodo:");
		Usuario obj = new Usuario();
		obj.setUsuario( "luis" );
		obj.setSenha( "felipe" );
		obj.setTipo("gestor");
		
		dao.insert(obj);
	}
	
	
	public static void main(String[] args) {
		new UsuarioTest().inserirObjeto();
	}
}
