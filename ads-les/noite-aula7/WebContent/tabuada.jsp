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
			<label>Escolha um número para calcular a tabuada</label>
			<input type="number" name="NUMERO"/>
			<button type="submit">Mostra Tabuada</button>
		</form>
		<%	int numero = 8;
			String strNumero = request.getParameter("NUMERO");
			try { 
				numero = Integer.parseInt(strNumero);
			} catch (Exception e) {
				// Apenas pula
			}
			for (int i = 0; i <= 10; i++) {
				int resultado = numero * i;
		%>
			<p><%=numero%> X <%=i%> = <%=resultado%>
		<% } %>
	</body>
</html>