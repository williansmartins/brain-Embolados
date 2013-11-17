package com.williansmartins.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Willians Martins
 */

@Table(name = "usuario")
@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private String sexo;
	private String cidade;
	private String estado;
	private String telefone;
	private String nascimento;
	private String usuario;
	private String tipo;

	
	
	public Usuario() {
		super();
	}
	public Usuario(Long id, String nome, String email, String cpf, String senha,
			String sexo, String cidade, String estado, String telefone,
			String nascimento, String usuario, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.sexo = sexo;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.usuario = usuario;
		this.tipo = tipo;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
