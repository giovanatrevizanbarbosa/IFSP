<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List, br.edu.ifsp.arq.web1.model.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pessoas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body class="d-flex justify-content-evenly p-5">
	<% List<Person> people = (List<Person>) request.getAttribute("list"); %>
	<table class="table table-dark table-hover">
		<tr>
			<th scope="col">Nome</th>
			<th scope="col">CPF</th>
			<th scope="col">E-mail</th>
		</tr>
		<% for(Person person: people) { %>
		<tr>
			<td><%= person.getName() %></td>
			<td><%= person.getCpf() %></td>
			<td><%= person.getEmail() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>