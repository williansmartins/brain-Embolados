package com.williansmartins.exception;

/**
 * Componente de exceção para operações de persistência.
 * 
 * <p>A estratégia é utilizar uma <code>RuntimeException</code> para encapsular <code>SQLException</code>.</p>
 * 
 * @author Willians Martins
 */
public class PersistenceException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public PersistenceException(String msg) {
                super(msg);
        }
        
        public PersistenceException(Exception ex) {
                super(ex);
        }
        
        public PersistenceException(String msg, Exception ex) {
                super(msg, ex);
        }
        
}