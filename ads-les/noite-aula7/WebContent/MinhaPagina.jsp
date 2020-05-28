<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, java.util.Locale, edu.curso.Pet" %>
<%@ page errorPage="erro.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Minha Primeira Pagina</title>
	</head>
	<body>
		<%-- <%@ include file="./cabecalho.jsp" %> --%>
		<jsp:include page="./cabecalho.jsp">
			<jsp:param name="PAGINA" value="Minha Pagina"/>
		</jsp:include>
		<h1>Minha primeira pagina JSP</h1>
		<%
			// Locale.setDefault(new Locale("pt", "BR"));
			Locale.setDefault(Locale.ENGLISH);
			// SimpleDateFormat sdf = null; 
			SimpleDateFormat sdf = new SimpleDateFormat();
			// "E MMM dd hh:mm:ss zzz yyyy"
			// Wed May 27 20:04:48 BRT 2020
			String data = sdf.format(new Date());
		%>
		<jsp:useBean id="p1" class="edu.curso.Pet"/>
		<%
			// Pet p1 = new Pet();
			// p1.setNome("Toto");
			// p1.setRaca("Vira Lata");
		%>
		<jsp:setProperty name="p1" property="nome" value="Rex"/>
		
		<h3>Data: <%=data%></h3>
		<% if("Totó".equals(p1.getNome())) {  %>
			<h3>Meu cachorro prerido</h3>
		<% } else { %>
			<h3>Cahorro comum</h3>
		<% } %>
		<h4>Nome do Cachorro: <jsp:getProperty name="p1" property="nome"/>
		</h4>
	</body>
</html>