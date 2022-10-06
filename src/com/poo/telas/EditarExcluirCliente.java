package com.poo.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.poo.banco.ClienteBanco;
import com.poo.dto.Cliente;


public class EditarExcluirCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textNovoNome;
	private JTextField textCpf;
	private JTextField textNovoRg;
	private JTextField textNovoEmail;
	private JTextField textNovoTelefone;
	private JTextField textNovoEndereco;
	private JTextField textNovoTipo;
	
	ClienteBanco clientebanco = new ClienteBanco();
	Cliente cliente = new Cliente();
	
	public EditarExcluirCliente() {
		setTitle("Alterar/Excluir Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 150, 710, 503);
		this.setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblCadastro = new JLabel("Dados do Cliente");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastro.setBounds(130, 0, 179, 33);
		getContentPane().add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(47, 92, 59, 23);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(47, 41, 46, 23);
		getContentPane().add(lblCpf);
		
		JLabel lblRg = new JLabel("Rg:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRg.setBounds(47, 147, 46, 17);
		getContentPane().add(lblRg);
		
		textNovoNome = new JTextField();
		textNovoNome.setBounds(47, 116, 604, 20);
		getContentPane().add(textNovoNome);
		textNovoNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(103, 44, 432, 20);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		textNovoRg = new JTextField();
		textNovoRg.setBounds(47, 169, 604, 20);
		getContentPane().add(textNovoRg);
		textNovoRg.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(47, 251, 70, 23);
		getContentPane().add(lblTelefone);
		
		textNovoEmail = new JTextField();
		textNovoEmail.setBounds(47, 220, 604, 20);
		getContentPane().add(textNovoEmail);
		textNovoEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(47, 198, 46, 23);
		getContentPane().add(lblEmail);
		
		textNovoTelefone = new JTextField();
		textNovoTelefone.setBounds(47, 272, 604, 20);
		getContentPane().add(textNovoTelefone);
		textNovoTelefone.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereco.setBounds(47, 303, 81, 23);
		getContentPane().add(lblEndereco);
		
		textNovoEndereco = new JTextField();
		textNovoEndereco.setBounds(47, 325, 604, 20);
		getContentPane().add(textNovoEndereco);
		textNovoEndereco.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(47, 356, 46, 23);
		getContentPane().add(lblTipo);
		
		textNovoTipo = new JTextField();
		textNovoTipo.setBounds(47, 380, 604, 20);
		getContentPane().add(textNovoTipo);
		textNovoTipo.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cliente.setNome(textNovoNome.getText());
				cliente.setTelefone(textNovoTelefone.getText());
				cliente.setRg(textNovoRg.getText());
				cliente.setEmail(textNovoEmail.getText());
				cliente.setEndereco(textNovoEndereco.getText());
				cliente.setTipo(textNovoTipo.getText());
			
				clientebanco.atualizar(cliente);
				limpar();
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(82, 431, 98, 23);
		getContentPane().add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(318, 431, 89, 23);
		getContentPane().add(btnLimpar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textCpf.getText();
				cliente = clientebanco.consulta(textCpf.getText());
				limpar();
				
				textNovoNome.setText(cliente.getNome());
				textNovoTelefone.setText(cliente.getTelefone());
				textNovoRg.setText(cliente.getRg());	
				textNovoEmail.setText(cliente.getEmail());
				textNovoEndereco.setText(cliente.getEndereco());
				textNovoTipo.setText(cliente.getTipo());
		
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProcurar.setBounds(558, 43, 93, 23);
		contentPane.add(btnProcurar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConfirmacaoExcluirCliente confirmacaoCliente = new ConfirmacaoExcluirCliente(cliente.getNome());
				confirmacaoCliente.setVisible(true);
				confirmacaoCliente.toFront();
				confirmacaoCliente.requestFocus();
				limpar();
				
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBounds(527, 431, 89, 23);
		contentPane.add(btnExcluir);
	}

	
	public void limpar() {
		
		textCpf.setText("");
		textNovoNome.setText("");
		textNovoRg.setText("");
		textNovoEmail.setText("");
		textNovoTelefone.setText("");
		textNovoEndereco.setText("");
		textNovoTipo.setText("");
	
	}
	
}
