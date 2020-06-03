<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<form action="./petServlet" method="post">
			<div class="form-group">
				<label>Nome: </label>
				<input type="text" name="nome" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Raça: </label>
				<select name="raca" class="form-control">
					<option value="viralata">Vira Lata</option>
					<option value="viralata">Buldog</option>
					<option value="viralata">Poodle</option>
				</select>
			</div>
			<div class="form-group">
				<label>Nascimento: </label>
				<input type="date" pattern="ddMMyyyy" name="nascimento" class="form-control"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Adicionar</button>
			</div>
		</form>
	</div>
</body>
</html>