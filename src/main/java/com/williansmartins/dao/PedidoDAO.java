package com.williansmartins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.williansmartins.exception.PersistenceException;
import com.williansmartins.model.Pedido;
import com.williansmartins.model.Produto;

public class PedidoDAO {

	private final Connection connection;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public PedidoDAO(Connection connection) {
		this.connection = connection;
	}

	public void inserir(Pedido pedido) {
		if (pedido == null) {
            throw new PersistenceException("Informe o Pedido para salvar!");
	    }
	    
	    try {
            if (pedido.getId() == null) {
                    stmt = getStatementInsert(connection, pedido);
            } else {
                    stmt = getStatementUpdate(connection, pedido);
            }
            stmt.executeUpdate();
            connection.commit();
            System.out.print("Pedido foi salvo");
	    } catch (SQLException e) {
            try { connection.rollback(); } catch (Exception sx) {}
            String errorMsg = "Erro ao salvar Pedido!";
            System.out.print(errorMsg +  e);
            throw new PersistenceException(errorMsg, e);
	    } 
	}
    
	private PreparedStatement getStatementInsert(Connection conn, Pedido pedido) throws SQLException {
        stmt = createStatementWithLog(connection, "INSERT INTO PEDIDO (nome) VALUES (?)");
        stmt.setString(1, pedido.getNome());
        return stmt;
	}
	
	private PreparedStatement getStatementUpdate(Connection conn, Pedido pedido) throws SQLException {
	        stmt = createStatementWithLog(connection, "UPDATE PEDIDO SET id = ? WHERE id = " + pedido.getId());
	        stmt.setInt(1, pedido.getId());
	        return stmt;
	}

	public Pedido buscar(Pedido pedido) {
		if ( pedido.getId() == null ) {
        	System.out.println( "Informe o id válido para fazer a busca!" );
        }
        Pedido pedidoRetornado = null;
        try {
	        	StringBuilder query = new StringBuilder();
	        	query.append("select pedido.id as id, pedido.nome as nome, p.descricao as descricao, p.preco as preco, p.id as id_produto, pp.quantidade as quantidade ");
	        	query.append("from pedido as pedido ");
	        	query.append("INNER JOIN produto as p ");
	        	query.append("INNER JOIN pedido_produto as pp ON pp.id_pedido = pedido.id and p.id = pp.id_produto ");
	        	query.append("WHERE pedido.id = ? ");
	        	System.out.println(">>"+query.toString());

                stmt = connection.prepareStatement(query.toString());
                stmt.setInt(1, pedido.getId());
                rs = stmt.executeQuery();
                
                if (rs.next()) {
	                	Produto produto = new Produto(rs.getString("descricao"), rs.getBigDecimal("preco"), rs.getInt("quantidade"));
                		pedidoRetornado = new Pedido(produto);
                		pedidoRetornado.setNome(rs.getString("nome"));
                        pedidoRetornado.setId(rs.getInt("id"));
                }
                
                return pedidoRetornado;
        } catch (SQLException e) {
                String errorMsg = "Erro ao consultar pedido por id!";
                System.out.print(errorMsg +  e);
                throw new PersistenceException(errorMsg, e);
        } 
	}
    private static PreparedStatement createStatementWithLog(Connection conn, String sql) throws SQLException{
        if (conn == null)
                return null;
        
        System.out.print("SQL: "+sql);
        return conn.prepareStatement(sql);
	}

	public void close() {
        ConnectionManager.closeAll(connection, stmt, rs);
	}
}
