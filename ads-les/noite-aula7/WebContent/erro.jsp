<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina</title>
</head>
<body>
	<jsp:include page="./cabecalho.jsp">
		<jsp:param name="PAGINA" value="Pagina de Erro"/>
	</jsp:include>
	<h2>Ooops.. acontenceu um problema no sistema</h2>
	<h3>Por favor contate o administrador</h3>
</body>
</html>