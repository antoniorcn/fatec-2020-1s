<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List, edu.curso.Pet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registro de Pets</title>
		
		<!--  <link rel="stylesheet" href="./resource/css/bootstrap.min.css"> -->
		<!-- CSS only -->
		<link rel="stylesheet" href="./resource/css/bootstrap.min.css"/>
		
	</head>
	<body>
		<div class="container">
			<h1>Registro de Pets</h1>
			<c:if test="${not empty mensagem}">
				<div class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong>Sucesso</strong>${mensagem}
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			</c:if>
			<form:form action="./petAdicionar" method="post" modelAttribute="pet">
				<div class="form-group">
					<label>Nome do Pet:</label>
					<form:input type="text" path="nome" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Raça:</label>
					<form:input type="text" path="raca" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Nascimento: </label>
					<form:input type="text" path="nascimento" class="form-control"/>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Adicionar</button>
				</div>
				
	  				<table class="table table-striped">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Raça</th>
								<th>Nascimento</th>
							</tr>
						</thead>
						<tbody> 
							<c:forEach items = "${lista}" var = "pet">
								<tr>
									<td>${pet.nome}</td>
									<td>${pet.raca}</td>
									<td>${pet.nascimento}</td>
								</tr>
         					</c:forEach>
						</tbody>
					</table>
			</form:form>
		</div>
	</body>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>