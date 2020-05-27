<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabuada</title>
</head>
<body>
	<h1>Tabuada</h1>
	
	<form>
		<p>Escolha o numero para mostrar na tabuada</p>
		<input type="number" name="NUMERO"/>
		<button type="submit">Mostrar Tabuada</button>
	</form>
	<% 
		int numero = 7;
		try { 
			String strNumero = request.getParameter("NUMERO");
			numero = Integer.parseInt(strNumero);
		} catch (Exception e){ 
			// Apenas passar em branco
		}
	%>
	
	<% for (int i = 0; i < 10; i++) {  
		int resultado = numero * i; %>
		<p><%=numero%> X <%=i%> = <%=resultado%></p>
	<% }  %>
</body>
</html>