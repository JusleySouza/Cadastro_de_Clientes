package com.poo.telas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.poo.banco.ClienteBanco;
import com.poo.dto.Cliente;


public class ListarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabela;
	DefaultTableModel modelo;
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	private ClienteBanco clienteBanco = new ClienteBanco();

	public ListarCliente() {
		
		
		setTitle("Lista de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 710, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cpf");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("Tipo");
		
		tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 674, 446);
		contentPane.add(scrollPane);
		
		listaClientes = clienteBanco.listar();
		for(Cliente cliente : listaClientes) {	
			modelo.addRow(new Object[] {cliente.getCpf(), cliente.getNome(),cliente.getTelefone(), cliente.getEmail(), cliente.getTipo()});
		}
	}
}
