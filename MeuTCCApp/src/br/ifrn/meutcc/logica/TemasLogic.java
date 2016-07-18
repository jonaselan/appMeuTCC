package br.ifrn.meutcc.logica;

import java.util.List;

import br.ifrn.meutcc.modelo.Tema;
import br.ifrn.meutcc.modelo.Orientador;

public class TemasLogic {
	private Tema tema;
	
	public TemasLogic() {
		tema = new Tema();
	}

	public List<Tema> listTemas(int idCurso) {
		return tema.listTemas(idCurso);
	}

	public Tema getTema(int idTema) {
		return tema.getTema(idTema);
	}

	public int countCandidatos(int idTema) {
		return tema.countCandidatos(idTema);
	}
	
	public Orientador getOrientador(String matriculaOrientador) {
		return tema.getOrientador(matriculaOrientador);
	}
}
