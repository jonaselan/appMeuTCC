package br.ifrn.meutcc.visao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.meutcc.logica.CandidatosLogic;
import br.ifrn.meutcc.logica.TemasLogic;
import br.ifrn.meutcc.modelo.Tema;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@WebServlet("/addCandidato")
public class addCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public addCandidato() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTemaParam = request.getParameter("idTema");
		String idAlunoParam = request.getParameter("idAluno");
		int idTema = -1;
		int idAluno = -1;
		int registrado = 0;

		try {
			idTema = Integer.parseInt(idTemaParam);
			idAluno = Integer.parseInt(idAlunoParam);

		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
		}

		CandidatosLogic logicCandidatos = new CandidatosLogic();
		registrado = logicCandidatos.addCandidato(idAluno, idTema);
			
		TemasLogic logicTemas = new TemasLogic();
		Tema tema = logicTemas.getTema(idTema);
		
		int qtdCandidatos = logicTemas.countCandidatos(idTema);

		request.setAttribute("tema", tema);
		request.setAttribute("qtdCandidatos", qtdCandidatos);
		request.setAttribute("registrado", registrado);
		request.getRequestDispatcher("viewTema.jsp").forward(request, response);
	}

}
