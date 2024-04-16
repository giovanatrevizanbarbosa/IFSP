<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/person-walking.svg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="css/home.css" rel="stylesheet">
    <title>IFitness - Página Inicial</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">IFitness</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="activity-register.jsp">Nova Atividade</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Estatísticas</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        ${name}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Minha Conta</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Sair</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Pesquisar" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="center col-lg-12 col-sm-12 mt-5">
        <h1 class="text-center">Atividades</h1>
        <c:choose>
            <c:when test="${fn:length(userActivities) > 0}">
                <table class="table table-striped table-hover table-responsive">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Data</th>
                        <th scope="col">Distância (km)</th>
                        <th scope="col">Duração (minutos)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="activity" items="${userActivities}" varStatus="index">
                        <tr>
                            <th scope="row">${index.count}</th>
                            <td>
                                <c:choose>
                                    <c:when test="${activity.type == 'CORRIDA'}">
                                        <img src="img/running_icon.png" alt="Corrida" title="Corrida">
                                    </c:when>
                                    <c:when test="${activity.type == 'CAMINHADA'}">
                                        <img src="img/walking_icon.png" alt="Caminhada" title="Caminhada">
                                    </c:when>
                                    <c:when test="${activity.type == 'CICLISMO'}">
                                        <img src="img/cycling_icon.png" alt="Ciclismo" title="Ciclismo">
                                    </c:when>
                                    <c:when test="${activity.type == 'NATACAO'}">
                                        <img src="img/swimming_icon.png" alt="Natação" title="Natação">
                                    </c:when>
                                </c:choose></td>
                            <td>
                                <fmt:parseDate value="${activity.date}" pattern="yyyy-MM-dd" var="parsedDate"
                                               type="date"/>
                                <fmt:formatDate value="${parsedDate}" var="formattedDate" type="date"
                                                pattern="dd/MM/yyyy"/>
                                    ${formattedDate}
                            </td>
                            <td>${activity.distance}</td>
                            <td>${activity.duration}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <c:out value="Nenhuma atividade cadastrada."></c:out>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>