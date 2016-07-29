<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.ifrn.meutcc.modelo.Tema, br.ifrn.meutcc.modelo.Orientador"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu TCC</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<h1>Detalhes do Tema</h1>
	<%
		Tema tema = (Tema) request.getAttribute("tema");
		Orientador orientador = (Orientador) request.getAttribute("orientador");
		int qtdCandidatos = (int) request.getAttribute("qtdCandidatos");
		int registrado = (int) request.getAttribute("registrado");
		
		switch (registrado) {
		case 1:
			out.println("<div class='alert alert-success'> <strong>Parab�ns</strong> Voc� se cadastrou nesse tema! </div>");
			break;
		case 2:
			out.println("<div class='alert alert-danger'> <strong>Opa</strong> Voc� j� se cadastrou nesse tema! </div>");
			break;
		default:
		}
	
		
		if (tema != null) {
			out.println("<h3>"+tema.getTitulo()+"</h3>");
			out.println("<ul>");
			out.println("<li> ID = "+tema.getId()+"</li>");
			out.println("<li> Descri��o = "+tema.getDescricao()+"</li>");
			out.println("<li> Candidatos interessados = "+qtdCandidatos+"</li>");
			out.println("</ul>");
			
			if (orientador != null) {
				out.println("<h4>Orientador: "+orientador.getNome()+"</h4>");
			} else {
				out.println("<h4>Nenhum orientador est� cadastrado para esse tema!</h4>");
			}
			
		} else {
			out.println("<h3>N�o h� nenhum tema para mostrar!</h3>");
		}
		
		out.println("<form action='addCandidato' method='POST'>");
		out.println("<input type='hidden' name='idAluno' value='1' />");
		out.println("<input type='hidden' name='idTema' value="+tema.getId()+" />");
		out.println("<a class='btn btn-primary' href='#' onclick='this.parentNode.submit()'>candidatar</a>");
		out.println("</form>");
	%>
</div>
</body>
</html>