package com.poo.dto;

public class Cliente {

	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String telefone;
	private String endereco;
	private String tipo;
	
	public Cliente() {}
	
	public Cliente(String nome, String telefone, String cpf, String rg, String email, String endereco,
			String tipo) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.endereco = endereco;
		this.tipo = tipo;
	}
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	


	public Cliente(String cpf, String nome, String telefone, String email, String tipo) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.tipo = tipo;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email + ", telefone=" + telefone
				+ ", endereco=" + endereco + ", tipo=" + tipo + "]";
	}

}
