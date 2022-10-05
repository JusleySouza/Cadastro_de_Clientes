package com.poo.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.poo.dto.Cliente;


public class ClienteBanco {

	Connection conect;
	Statement sentenca;
	ResultSet procura;
	int registros;

	public ClienteBanco() {
		conect = Conexao.conectaBD();
	}

	public int cadastrar(String nome, String telefone, String cpf, String rg, String email, String endereco,
			String tipo) {
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("INSERT into clientes values('" + nome + "','" + telefone + "',"
					+ "'"+ cpf + "', '" + rg + "', '" + email + "','" + endereco + "','" + tipo + "')");
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		return registros;
	}

	public Cliente consulta(String cpf) {
		Cliente cliente = new Cliente();

		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT * FROM clientes WHERE cpf='" + cpf + "' LIMIT 1");

			if (procura.next()) {

				cliente.setNome(procura.getString("nome"));
				cliente.setTelefone(procura.getString("telefone"));
				cliente.setCpf(procura.getString("cpf"));
				cliente.setRg(procura.getString("rg"));
				cliente.setEmail(procura.getString("email"));
				cliente.setEndereco(procura.getString("endereco"));
				cliente.setTipo(procura.getString("tipo"));

			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}

		return cliente;

	}

	public void atualizar(Cliente cliente) {
		try {
			sentenca = conect.createStatement();
			registros = sentenca.executeUpdate("UPDATE clientes SET nome='" + cliente.getNome() + "'," + "telefone='"
					+ cliente.getTelefone() + "'," + "cpf='" + cliente.getCpf() + "', rg ='" + cliente.getRg()
					+ "', email='" + cliente.getEmail() + "', endereco='" + cliente.getEndereco() + "'," + " tipo='"
					+ cliente.getTipo() + "'  WHERE cpf='" + cliente.getCpf() + "'");
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void excluir(String nome) {
		try {
			sentenca = conect.createStatement();
			sentenca.executeUpdate("DELETE FROM clientes  WHERE nome='"+nome+"'");
			JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		
		try {
			sentenca = conect.createStatement();
			procura = sentenca.executeQuery("SELECT cpf, nome, telefone, email, tipo FROM clientes");
			
			while(procura.next()) {
				Cliente cliente =  new Cliente();
				
				cliente.setCpf(procura.getString("cpf"));
				cliente.setNome(procura.getString("nome"));
				cliente.setTelefone(procura.getString("telefone"));
				cliente.setEmail(procura.getString("email"));
				cliente.setTipo(procura.getString("tipo"));
				
				
				listaClientes.add(cliente);
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		
		return listaClientes;
	}

}
