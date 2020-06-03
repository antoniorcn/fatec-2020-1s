<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, edu.curso.Pet" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/>
	<title>Registro de Pets</title>
</head>
<body>
	<div class="container">
		<h1>Registro de Pets</h1>
		<%
			String msg = (String)session.getAttribute("MENSAGEM");
			List<Pet> lista = (List<Pet>)application.getAttribute("LISTA");
			if (msg != null) {
				session.setAttribute("MENSAGEM", null);
		%>
			<div class="alert alert-success" role="alert">
				<%=msg%>
			</div>
		<% } %>
		<form action="./petServlet" method="post">
			<div class="form-group">
				<label>Nome: </label>
				<input type="text" name="nome" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Raça: </label>
				<select name="raca" class="form-control">
					<option value="viralata">Vira Lata</option>
					<option value="buldog">Buldog</option>
					<option value="poodle">Poodle</option>
				</select>
			</div>
			<div class="form-group">
				<label>Nascimento: </label>
				<input type="date" pattern="ddMMyyyy" name="nascimento" class="form-control"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" name="cmd" value="adicionar">Adicionar</button>
				<button type="submit" class="btn btn-primary" name="cmd" value="pesquisar">Pesquisar</button>
			</div>
			<% if (lista != null && lista.size() > 0) { %>
				<table class="table table-striped" style="margin-top: 50px;">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Raça</th>
							<th>Nascimento</th>
						</tr>
					</thead>
					<tbody>
						<%for (Pet p : lista) { %>
							<tr>
								<td><%=p.getNome()%></td>
								<td><%=p.getRaca()%></td>
								<td><%=p.getNascimento()%></td>
							</tr>
						<% } %>
					</tbody>	
				</table>
			<% } %>
		</form>
	</div>
</body>
</html>