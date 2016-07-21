package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class CandidatoDAO {
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	
	public CandidatoDAO() {
		super();
	}
	
	public int addCandidato(int idAluno, int idTema) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement st = conn.createStatement();
				int registered = st.executeUpdate("INSERT INTO candidato (idAluno, idTema) VALUES (" + idAluno + "," + idTema +")");
				if (registered > 0) {					
					return 1;
				}
				
				return 0;
			
			} catch (MySQLIntegrityConstraintViolationException ea) {
				return 2;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
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
