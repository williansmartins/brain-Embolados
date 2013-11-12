package com.williansmartins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.williansmartins.exception.PersistenceException;
import com.williansmartins.model.Pedido;

public class PedidoDAOJDBC{

        //comandos SQL utilizados pelo DAO.
		private final static String TABLE = "PEDIDO_JDBC";
        private final static String CREATE_TABLE = "CREATE TABLE " + TABLE + " ( id int(11) NOT NULL AUTO_INCREMENT, nome varchar(255) DEFAULT NULL, lanche varchar(255) DEFAULT NULL, bebida varchar(255) DEFAULT NULL, PRIMARY KEY (id) );";
        private final static String INSERT_PEDIDO = "INSERT INTO  " + TABLE + "  (nome,lanche,bebida) VALUES (?,?,?)";
        private final static String UPDATE_PEDIDO = "UPDATE  " + TABLE + "  SET nome = ?, lanche = ?, bebida = ? WHERE id = ?";
        private final static String DELETE_PEDIDO = "DELETE FROM  " + TABLE + "  WHERE id = ?";
        private final static String GET_ALL_PEDIDOS = "SELECT * FROM  " + TABLE + " ";
        private final static String GET_PEDIDOS_BY_NOME = "SELECT * FROM  " + TABLE + "  WHERE nome like ?";
        private final static String GET_PEDIDO_BY_ID = "SELECT * FROM  " + TABLE + "  WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        public void init() throws PersistenceException{
                Connection conn = null;
                Statement stmt = null;
                try {
                    conn = ConnectionManager.getConnection();
                    stmt = conn.createStatement();
                    int r = stmt.executeUpdate(CREATE_TABLE);
                    
                    if (r > 0) {
                            System.out.print("Criou a tabela:" + TABLE );
                    }
                } catch (SQLException e) {
                    System.out.print("\nHouve um problema ao criar a tabela: " + e);
                    throw new PersistenceException("Não foi possivel inicializar o banco de dados: " + CREATE_TABLE, e);
                } finally {
                        ConnectionManager.closeAll(conn, stmt);
                }
        }
        
        public int save(Pedido pedido) throws PersistenceException {
        	 try {
                    conn = ConnectionManager.getConnection();
                    if (pedido.getId() == null) {
                            stmt = getStatementInsert(conn, pedido);
                    } else {
                            stmt = getStatementUpdate(conn, pedido);
                    }
                    stmt.executeUpdate();
                    
                    ResultSet rs = stmt.getGeneratedKeys();

					while(rs.next()){
						pedido.setId(rs.getInt(1));
                    }

                    conn.commit();
                    System.out.print("Pedido foi salvo");
                } catch (SQLException e) {
                    try { conn.rollback(); } catch (Exception sx) {}
                    String errorMsg = "Erro ao salvar Pedido!";
                    System.out.print(errorMsg +  e);
                    throw new PersistenceException(errorMsg, e);
                } finally {
                    ConnectionManager.closeAll(conn, stmt);
                }
        	 return pedido.getId();
        }
        
        private PreparedStatement getStatementInsert(Connection conn, Pedido pedido) throws SQLException {
                PreparedStatement stmt = createStatementWithLog(conn, INSERT_PEDIDO);
                stmt.setString(1, pedido.getNome());
                stmt.setString(2, pedido.getLanche());
                stmt.setString(3, pedido.getBebida());
                return stmt;
        }
        
        private PreparedStatement getStatementUpdate(Connection conn, Pedido pedido) throws SQLException {
                PreparedStatement stmt = createStatementWithLog(conn, UPDATE_PEDIDO);
                stmt.setString(1, pedido.getNome());
                stmt.setString(2, pedido.getLanche());
                stmt.setString(3, pedido.getBebida());
                stmt.setInt(4, pedido.getId());
                return stmt;
        }

      public Pedido findById(Integer id) throws PersistenceException {
      if (id == null || id.intValue() <= 0) {
      	throw new PersistenceException("Informe o id válido para fazer a busca!");
      }
      ResultSet rs = null;
      Pedido m = null;
      
      try {
          conn = ConnectionManager.getConnection();
          stmt = createStatementWithLog(conn, GET_PEDIDO_BY_ID);
          stmt.setInt(1, id);
          rs = stmt.executeQuery();
          
          if (rs.next()) {
                  String nome = rs.getString("nome");
                  String lanche = rs.getString("lanche");
                  String bebida = rs.getString("bebida");
                  
                  m = new Pedido(id, nome, lanche, bebida);
          }
          return m;
      } catch (SQLException e) {
          String errorMsg = "Erro ao consultar pedido por id!";
          System.out.print(errorMsg +  e);
          throw new PersistenceException(errorMsg, e);
      } finally {
          ConnectionManager.closeAll(conn, stmt, rs);
      }
}
        
        public void remove(Integer id) throws PersistenceException {
                if ( id == null ) {
                	 throw new PersistenceException("Informe o ID para exclusao!");
                }
                Connection conn = null;
                PreparedStatement stmt = null;
                try {
                    conn = ConnectionManager.getConnection();
                    stmt = createStatementWithLog(conn, DELETE_PEDIDO);
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
                    conn.commit();
                    System.out.print("Pedido foi excluida");
                } catch (SQLException e) {
                    try { conn.rollback(); } catch (Exception sx) {}
                    String errorMsg = "Erro ao excluir Pedido!";
                    System.out.print(errorMsg +  e);
                    throw new PersistenceException(errorMsg, e);
                }finally{
                    ConnectionManager.closeAll(conn, stmt);
                }
        }
//        
//        
//        public Pedido findById(Integer id) throws PersistenceException {
//                if (id == null || id.intValue() <= 0) {
//                	throw new PersistenceException("Informe o id válido para fazer a busca!");
//                }
//                Connection conn = null;
//                PreparedStatement stmt = null;
//                ResultSet rs = null;
//                Pedido m = null;
//                
//                try {
//                        conn = ConnectionManager.getConnection();
//                        stmt = createStatementWithLog(conn, GET_PEDIDO_BY_ID);
//                        stmt.setInt(1, id);
//                        rs = stmt.executeQuery();
//                        
//                        if (rs.next()) {
//                                String nome = rs.getString("nome");
//                                String lanche = rs.getString("lanche");
//                                String bebida = rs.getString("bebida");
//                                
//                                m = new Pedido(id, nome, lanche, bebida);
//                        }
//                        return m;
//                } catch (SQLException e) {
//                        String errorMsg = "Erro ao consultar pedido por id!";
//                        System.out.print(errorMsg +  e);
//                        throw new PersistenceException(errorMsg, e);
//                } finally {
//                        ConnectionManager.closeAll(conn, stmt, rs);
//                }
//        }
//        
//        
        public List<Pedido> findAll() throws PersistenceException {
                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                
                try {
                        conn = ConnectionManager.getConnection();
                        stmt = createStatementWithLog(conn, GET_ALL_PEDIDOS);
                        rs = stmt.executeQuery();
                        
                        return toPedidos(rs);
                } catch (SQLException e) {
                        String errorMsg = "Erro ao consultar todas as pedidos!";
                        throw new PersistenceException(errorMsg, e);
                } finally {
                        ConnectionManager.closeAll(conn, stmt, rs);
                }
        }
//        
//        
//        @SuppressWarnings("unchecked")
//        public List<Pedido> getPedidosByNome(String nome) throws PersistenceException {
//                if (nome == null || nome.isEmpty()) {
//                        return Collections.EMPTY_LIST;
//                }
//                
//                Connection conn = null;
//                PreparedStatement stmt = null;
//                ResultSet rs = null;
//                
//                try {
//                        conn = ConnectionManager.getConnection();
//                        stmt = createStatementWithLog(conn, GET_PEDIDOS_BY_NOME);
//                        stmt.setString(1, nome + "%");
//                        rs = stmt.executeQuery();
//                        
//                        return toPedidos(rs);
//                } catch (SQLException e) {
//                        String errorMsg = "Erro ao consultar pedidos por nome!";
//                        System.out.print(errorMsg +  e);
//                        throw new PersistenceException(errorMsg, e);
//                } finally {
//                        ConnectionManager.closeAll(conn, stmt, rs);
//                }
//        }
//        
        private List<Pedido> toPedidos(ResultSet rs) throws SQLException {
                List<Pedido> lista = new ArrayList<Pedido>();
                while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String lanche = rs.getString("lanche");
                        String bebida = rs.getString("bebida");
                        
                        lista.add(new Pedido(id, nome, lanche, bebida));
                }
                return lista;
        }
//
        private static PreparedStatement createStatementWithLog(Connection conn, String sql) throws SQLException{
                if (conn == null)
                        return null;
                
                System.out.print("SQL: "+sql);
                return conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        }

}
