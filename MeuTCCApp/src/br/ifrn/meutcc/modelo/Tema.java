package br.ifrn.meutcc.modelo;

import java.util.List;

import br.ifrn.meutcc.persistencia.TemaDAO;
import br.ifrn.meutcc.persistencia.FabricaDAO;

public class Tema {
	private int id;
	private String titulo;
	private String descricao;
	private String matriculaOrientador;
	private TemaDAO dao;
	public Tema() {
		super();
		try {
			FabricaDAO f = FabricaDAO.getFabrica();
			dao = f.createTemaDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getMatriculaOrientador() {
		return matriculaOrientador;
	}
	public void setMatriculaOrientador(String matriculaOrientador) {
		this.matriculaOrientador = matriculaOrientador;
	}
	
	public List<Tema> listTemas(int idCurso) {
		return dao.listTemas(idCurso);
	}
	public Tema getTema(int idTema) {
		return dao.getTema(idTema);
	}
	
	public Orientador getOrientador(String matriculaOrientador) {
		return dao.getOrientador(matriculaOrientador);		
	}
	
	public int countCandidatos(int idTema) {
		return dao.countCandidatos(idTema);
	}
}
