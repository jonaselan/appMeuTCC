package br.ifrn.meutcc.logica;

import br.ifrn.meutcc.modelo.Candidato;

public class CandidatosLogic {
	private Candidato candidato;
	
	public CandidatosLogic() {
		candidato = new Candidato();
	}
	
	public boolean addCandidato(int idAluno, int idTema) {
		return candidato.addCandidato(idAluno, idTema);
	}

}
