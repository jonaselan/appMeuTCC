package br.ifrn.meutcc.modelo;

import br.ifrn.meutcc.persistencia.CandidatoDAO;

public class Candidato {
	private CandidatoDAO dao;
	
	public Candidato() {
		super();
		dao = new CandidatoDAO();
	}
	
	public boolean addCandidato(int idAluno, int idTema) {
		return dao.addCandidato(idAluno, idTema);
	}

}
