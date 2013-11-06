package com.williansmartins.dao;

import java.util.List;

import com.williansmartins.model.Pedido;


/**
 * Contrato de persistência para a entidade <code>Mercadoria</code>. 
 * 
 * <p>Define as operações basicas de cadastro (CRUD), seguindo o design pattern <code>Data Access Object</code>.</p>
 * 
 * @author Willians Martins
 */
public interface PedidoDAO {

        /**
         * Faz a inserção ou atualização da mercadoria na base de dados.
         * @param mercadoria
         * @throws <code>PersistenceException</code> se algum problema ocorrer.
         */
        void save(Pedido mercadoria);
        
        /**
         * Exclui o registro da mercadoria na base de dados.
         * @param mercadoria
         * @throws <code>PersistenceException</code> se algum problema ocorrer.
         */
        void remove(Pedido mercadoria);
        
        /**
         * @return Lista com todas as mercadorias cadastradas no banco de dados.
         * @throws <code>PersistenceException</code> se algum problema ocorrer.
         */
        List<Pedido> getAll();
        
        /**
         * @param nome Filtro da pesquisa utilizando like.
         * @return Lista de mercadorias com filtro em nome.
         * @throws <code>PersistenceException</code> se algum problema ocorrer.
         */
        List<Pedido> getPedidosByNome(String nome);
        
        /**
         * @param id filtro da pesquisa.
         * @return Mercadoria com filtro no id, caso não exista retorna <code>null</code>.
         * @throws <code>PersistenceException</code> se algum problema ocorrer.
         */
        Pedido findById(Integer id);

        /**
         * Inicializa o componente de persistência.
         * @throws <code>PersistenceException</code> se algum problema ocorrer.
         */
        void init();
}