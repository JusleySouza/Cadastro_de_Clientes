package com.poo.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexao {

	static Connection conexao = null;
	static PreparedStatement stm;

	public static String status = "Não conectado...";
		
	public Conexao() {
		
	}

		public static Connection conectaBD() {
			try {
		    	Class.forName("com.mysql.cj.jdbc.Driver"); 	
		    	conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_poo"+"?useTimezone=true&serverTimezone=UTC","root","1234");
		    } catch (Exception e) {
		    		System.out.println("Não foi possível conectar ao bd: " + e.getMessage());
		    	}
			
			return conexao;
		}

	public static boolean FecharConexao() {
	    try {
	       Conexao.conectaBD().close();
	       return true;
	    } catch (SQLException e) {
	        return false;
	    }
	}

	public static java.sql.Connection ReiniciarConexao() {
	    FecharConexao();
	    return Conexao.conectaBD();
	}
	
}
