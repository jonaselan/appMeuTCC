<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.ifrn.meutcc.modelo.Tema"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meu TCC</title>
</head>
<body>
<h1>Detalhes do Tema</h1>
<%
	Tema tema = (Tema) request.getAttribute("tema");
	int qtdCandidatos = (int) request.getAttribute("qtdCandidatos");

	boolean registrado = (boolean) request.getAttribute("registrado");
	
	if (registrado) {
		out.println("<h1>Registro efetuado!</h1>");
	}

	
	if (tema != null) {
		out.println("<h3>"+tema.getTitulo()+"</h3>");
		out.println("<ul>");
		out.println("<li> ID = "+tema.getId()+"</li>");
		out.println("<li> Descrição = "+tema.getDescricao()+"</li>");
		out.println("<li> Candidatos interessados = "+qtdCandidatos+"</li>");
		out.println("</ul>");
	} else {
		out.println("<h3>Não há nenhum tema para mostrar!</h3>");
	}
	
	out.println("<form action='addCandidato' method='POST'>");
	out.println("<input type='hidden' name='idAluno' value='1' />");
	out.println("<input type='hidden' name='idTema' value="+tema.getId()+" />");
	out.println("<a href='#' onclick='this.parentNode.submit()'>candidatar</a>");
	out.println("</form>");
%>
</body>
</html>