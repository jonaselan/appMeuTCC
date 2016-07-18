package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CandidatoDAO {
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	
	public CandidatoDAO() {
		super();
	}
	
	public boolean addCandidato(int idAluno, int idTema) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement st = conn.createStatement();
				int registered = st.executeUpdate("INSERT INTO candidato (idAluno, idTema) VALUES (" + idAluno + "," + idTema +")");
				if (registered > 0) {					
					return true;
				}
				
				return false;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	
	private void verificaConexao() {
		String 	url = "jdbc:mysql://localhost/meutcc",
				nome = "root",
				senha = "root";
		if (conn != null) {
			return;
		}
		try {
			Class.forName(MySQLDriver);
			conn = DriverManager.getConnection(url, nome, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
