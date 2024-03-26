<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List, br.edu.ifsp.arq.web1.projetojstl.model.Person" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Pessoas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body class="d-flex justify-content-evenly p-5">
	<c:choose>
		<c:when test="${fn:length(list) > 0}">
			<table class="table table-dark table-hover">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">E-mail</th>
				</tr>
				<c:forEach var="person" items="${list}" varStatus="cont">
					<tr>
						<td>${cont.count}</td>
						<td>${person.name}</td>
						<td>${person.cpf}</td>
						<td>${person.email}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<c:out value="Nenhuma pessoa registrada"></c:out>
		</c:otherwise>
	</c:choose>
</body>
</html>