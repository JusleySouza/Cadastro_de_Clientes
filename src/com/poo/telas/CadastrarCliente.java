package com.poo.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.poo.banco.ClienteBanco;

public class CadastrarCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textRg;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTextField textEndereco;
	private JTextField textTipo;
	
	private String nome, telefone, cpf, rg, email, endereco, tipo;
	
	public CadastrarCliente() {
		setTitle("Cadastrar Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 150, 710, 503);
		this.setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro de Cliente");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastro.setBounds(246, 0, 179, 33);
		getContentPane().add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(44, 36, 59, 23);
		getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(46, 92, 46, 23);
		getContentPane().add(lblCpf);
		
		JLabel lblRg = new JLabel("Rg:");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRg.setBounds(46, 147, 46, 17);
		getContentPane().add(lblRg);
		
		textNome = new JTextField();
		textNome.setBounds(45, 61, 579, 20);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setBounds(45, 116, 579, 20);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		textRg = new JTextField();
		textRg.setBounds(45, 169, 579, 20);
		getContentPane().add(textRg);
		textRg.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(44, 251, 70, 23);
		getContentPane().add(lblTelefone);
		
		textEmail = new JTextField();
		textEmail.setBounds(44, 220, 580, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(46, 200, 46, 23);
		getContentPane().add(lblEmail);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(44, 272, 580, 20);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereco.setBounds(44, 303, 81, 23);
		getContentPane().add(lblEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(44, 326, 580, 20);
		getContentPane().add(textEndereco);
		textEndereco.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(46, 358, 46, 23);
		getContentPane().add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setBounds(44, 380, 580, 20);
		getContentPane().add(textTipo);
		textTipo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nome = textNome.getText();
				telefone = textTelefone.getText();
				cpf = textCpf.getText();
				rg = textRg.getText();
				email = textEmail.getText();
				endereco = textEndereco.getText();
				tipo = textTipo.getText();
				
				ClienteBanco cliente = new ClienteBanco();
				int cadastro = cliente.cadastrar(nome, telefone,
						cpf, rg, email, endereco, tipo);
				
				if(cadastro!=0)
				{
					JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
					textNome.setText("");
					textTelefone.setText("");
					textCpf.setText("");
					textRg.setText("");
					textEmail.setText("");
					textEndereco.setText("");
					textTipo.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Erro para realizar o cadastro!!!","Erro",JOptionPane.ERROR_MESSAGE);
				}
			}
			{
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(210, 431, 98, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				textNome.setText("");
				textTelefone.setText("");
				textCpf.setText("");
				textRg.setText("");
				textEmail.setText("");
				textEndereco.setText("");
				textTipo.setText("");
				
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(402, 431, 89, 23);
		getContentPane().add(btnLimpar);
	}

	
}
