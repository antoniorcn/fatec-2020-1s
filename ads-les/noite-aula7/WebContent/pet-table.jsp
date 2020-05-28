<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registro de Pets</title>
		<link rel="stylesheet" href="./resource/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<h1>Registro de Pets</h1>
			<form>
				<table class="table">
					<tr>
						<td><label>Nome do Pet:</label></td>
						<td><input type="text" name="NOME" class="form-control"/></td>
					</tr>
					<tr>
						<td><label>Raça:</label></td>
						<td><select name="RACA" class="form-control">
								<option value="viralata">Vira Lata</option>
								<option value="bulldog">Bull Dog</option>
								<option value="poodle">Poodle</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>Nascimento: </label></td>
						<td><input type="date" pattern="dd/MM/yyyy" class="form-control"/></td>
					</tr>
					<tr>
						<td><button class="btn btn-primary">Adicionar</button></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>