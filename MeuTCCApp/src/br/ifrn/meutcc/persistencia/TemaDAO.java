package br.ifrn.meutcc.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.meutcc.modelo.Tema;
import br.ifrn.meutcc.modelo.Orientador;

public class TemaDAO {
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	
	public TemaDAO() {
		super();
	}
	
	public List<Tema> listTemas(int idCurso) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.idCurso = "+idCurso);
				List<Tema> temas = new ArrayList<Tema>();
				while (rsTemas.next()) {
					Tema tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					tema.setMatriculaOrientador(rsTemas.getString("matriculaOrientador"));
					temas.add(tema);
				}
				return temas;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public Tema getTema(int idTema) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stListaTema = conn.createStatement();
				ResultSet rsTemas = stListaTema.executeQuery("SELECT * FROM Tema as t WHERE t.id = "+idTema);
				Tema tema = null;
				if (rsTemas.next()) {
					tema = new Tema();
					tema.setId(rsTemas.getInt("id"));
					tema.setTitulo(rsTemas.getString("titulo"));
					tema.setDescricao(rsTemas.getString("descricao"));
					tema.setMatriculaOrientador(rsTemas.getString("matriculaOrientador"));
		
				}
				return tema;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Orientador getOrientador(String matriculaOrientador) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stOrientador = conn.createStatement();
				ResultSet rsOrientador = stOrientador.executeQuery("SELECT u.id, u.nome, u.matricula FROM tema t INNER JOIN usuario u on t.matriculaOrientador = u.matricula WHERE t.matriculaOrientador = "+matriculaOrientador);
				Orientador orientador = null;
				if (rsOrientador.next()) {
					orientador = new Orientador();
					orientador.setId(rsOrientador.getInt("u.id"));
					orientador.setNome(rsOrientador.getString("u.nome"));
					orientador.setMatricula(rsOrientador.getString("u.matricula"));		
				}
				return orientador;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int countCandidatos(int idTema) {
		verificaConexao();
		if (conn != null) {
			try {
				Statement stQtd = conn.createStatement();
				ResultSet rsQtdCand = stQtd.executeQuery("SELECT COUNT(idAluno) as qtd FROM tema t INNER JOIN candidato c ON t.id = c.idTema WHERE t.id = "+idTema);
				int qtd = 0;
				if (rsQtdCand.next()) {					
					qtd = rsQtdCand.getInt("qtd");
				}
				return qtd;
				
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