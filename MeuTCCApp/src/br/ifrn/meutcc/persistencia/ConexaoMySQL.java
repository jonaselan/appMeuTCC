package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL extends Conexao {
	
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	private Connection con = null;
	private String domain, usuario, senha, banco;
	
	public ConexaoMySQL(String domain, String banco, String usuario, String senha) {
		this.domain = domain;
		this.usuario = usuario;
		this.senha = senha;
		this.banco = banco;
	}
	
	public void conectarBD() {
		if (con != null) { return; }
		String 	url = "jdbc:mysql://"+ domain + "/" + banco;
		System.out.println(url);
		try {
			Class.forName(MySQLDriver);
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexaoBD() {
		return con;
	}
}
