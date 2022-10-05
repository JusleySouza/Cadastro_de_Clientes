package com.poo.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.poo.banco.ClienteBanco;

public class ConfirmacaoExcluirCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public ConfirmacaoExcluirCliente(String nome) {
		setTitle("Cliente");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 322, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tem certeza que deseja excluir?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 289, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 49, 286, 31);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(nome);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCancelar.setBounds(165, 131, 101, 31);
		contentPane.add(btnCancelar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteBanco clientebanco = new ClienteBanco();
				clientebanco.excluir(nome);
				dispose();
			}
		});
		btnOk.setFont(new Font("Dialog", Font.BOLD, 13));
		btnOk.setBounds(31, 132, 101, 29);
		contentPane.add(btnOk);
	}

}
