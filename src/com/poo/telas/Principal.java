package com.poo.telas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private CadastrarCliente cadCliente;
	private EditarExcluirCliente editCliente;
	private ListarCliente listCliente;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		
		cadCliente = new CadastrarCliente();
		editCliente = new EditarExcluirCliente();
		listCliente = new ListarCliente();
		
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 710, 503);
		this.setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastro.com");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblCadastro.setBounds(184, 131, 323, 144);
		getContentPane().add(lblCadastro);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 694, 22);
		contentPane.add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cadCliente.setVisible(true);
			}
		});
		mnCliente.add(mntmCadastrar);
		
		JMenuItem mntmAlterarExcluir = new JMenuItem("Alterar/Excluir");
		mntmAlterarExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				editCliente.setVisible(true);
			}
		});
		mnCliente.add(mntmAlterarExcluir);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				listCliente.setVisible(true);
			}
		});
		mnCliente.add(mntmListar);
	}
}
