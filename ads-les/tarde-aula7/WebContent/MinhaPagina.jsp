<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="./erro.jsp"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, edu.curso.Pessoa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="./cabecalho.jsp">
			<jsp:param name="TITULO" value="MINHA PAGINA"/>
		</jsp:include>
		<%-- <%@ include file="./cabecalho.jsp" %> --%>
		<!-- Este é um comentário de HTML  -->
		<%-- Este é um comentario de JSP --%>
		<h1>Minha Primeira Pagina JSP</h1>
		<% 
			// Este comentario é Java
			/* Comentario Java */
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format(new Date());
			// String s = "Texto";
			// s.toUpperCase();
		%>
		<jsp:useBean id="p1" class="edu.curso.Pessoa"/>
		<jsp:setProperty property="nome" name="p1" value="Fernando"/>
		<h2>Data hora: <%=data%></h2>
		<%-- <h3>Observação: <%=p1.getNome()%></h3> --%>
		<h3>Observação: <jsp:getProperty name="p1" property="nome"/></h3>
		
		<% if ("Antonio".equals(p1.getNome())) {  %>
			<h3>Bem vindo administrador</h3>
		<% } else { %>
			<h3>Bem vindo</h3>
		<% } %>
	</body>
</html>