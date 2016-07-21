package br.ifrn.meutcc.logica;

import br.ifrn.meutcc.modelo.Candidato;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class CandidatosLogic {
	private Candidato candidato;
	
	public CandidatosLogic() {
		candidato = new Candidato();
	}
	
	public int addCandidato(int idAluno, int idTema) {
		return candidato.addCandidato(idAluno, idTema);
	}

}
