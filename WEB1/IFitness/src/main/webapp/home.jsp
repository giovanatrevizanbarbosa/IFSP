<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/stopwatch-20-solid.svg">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="css/home.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <title>IFitness - Página Inicial</title>
</head>
<body>
<nav class="navbar navbar-expand-lg sticky-top bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="homeServlet">IFitness</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item mx-2">
                    <a class="btn btn-primary" href="activityRegister">Nova Atividade</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="btn btn-secondary" href="statistics">Estatísticas</a>
                </li>
                <li class="nav-item mx-2 dropdown">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        ${sessionScope.user.name}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="btn btn-secondary" href="#">Minha Conta</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="btn btn-secondary" href="logout">Sair</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Pesquisar" aria-label="Search">
                <button class="btn btn-success" type="button">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <i id="toggle-theme" class="btn bi bi-moon-fill"></i>
    <div class="center col-lg-12 col-sm-12 mt-5 text-center">
        <c:if test="${result == 'updated'}">
            <div class="alert alert-success alert-dismissible fade show mb-3" role="alert">
                <strong>Atividade salva.</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <form action="activitySearch" method="post">
            <div class="row">
                <div class="col-12 col-lg-3">
                    <div class="mb-2">
                        <label for="type">Tipo</label>
                        <select class="form-select"
                                name="type" id="type">
                            <c:if test="${activityType == null}">
                                <option value="" selected>Selecione</option>
                            </c:if>
                            <c:choose>
                                <c:when test="${activityType == 'CAMINHADA'}">
                                    <option value="CAMINHADA" selected>Caminhada</option>
                                </c:when>
                                <c:when test="${activityType != 'CAMINHADA'}">
                                    <option value="CAMINHADA">Caminhada</option>
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${activityType == 'CICLISMO'}">
                                    <option value="CICLISMO" selected>Ciclismo</option>
                                </c:when>
                                <c:when test="${activityType != 'CICLISMO'}">
                                    <option value="CICLISMO">Ciclismo</option>
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${activityType == 'CORRIDA'}">
                                    <option value="CORRIDA" selected>Corrida</option>
                                </c:when>
                                <c:when test="${activityType != 'CORRIDA'}">
                                    <option value="CORRIDA">Corrida</option>
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${activityType == 'NATACAO'}">
                                    <option value="NATACAO" selected>Natação</option>
                                </c:when>
                                <c:when test="${activityType != 'NATACAO'}">
                                    <option value="NATACAO">Natação</option>
                                </c:when>
                            </c:choose>
                        </select>
                    </div>
                </div>
                <div class="col-12 col-lg-3">
                    <div class="mb-2">
                        <label for="initial-date">Data inicial</label>
                        <c:if test="${initialDate == null}">
                            <input value="" type="date" name="initial-date" id="initial-date"
                                   class="form-control">
                        </c:if>
                        <c:if test="${initialDate != null}">
                            <input value="${initialDate}" type="date" name="initial-date" id="initial-date"
                                   class="form-control">
                        </c:if>
                    </div>
                </div>
                <div class="col-12 col-lg-3">
                    <div class="mb-2">
                        <label for="final-date">Data final</label>
                        <c:if test="${finalDate == null}">
                            <input value="" type="date" name="final-date" id="final-date"
                                   class="form-control">
                        </c:if>
                        <c:if test="${finalDate != null}">
                            <input value="${finalDate}" type="date" name="final-date" id="final-date"
                                   class="form-control">
                        </c:if>
                    </div>
                </div>
                <div class="col-12 col-lg-3 mt-3">
                    <button type="submit" class="btn btn-primary">Filtrar</button>
                </div>
            </div>
        </form>
        <c:choose>
            <c:when test="${fn:length(userActivities) > 0}">
                <table class="table table-striped table-hover table-responsive mt-5">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Data</th>
                        <th scope="col">Distância (km)</th>
                        <th scope="col">Duração (minutos)</th>
                        <th scope="col">Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="activity" items="${userActivities}" varStatus="index">
                        <tr>
                            <th scope="row">${index.count}</th>
                            <td>
                                <c:choose>
                                    <c:when test="${activity.type == 'CORRIDA'}">
                                        <i class='activity-icon mt-2 fas fa-running' data-bs-toggle="tooltip"
                                           data-bs-placement="top"
                                           data-bs-title="Corrida"></i>
                                    </c:when>
                                    <c:when test="${activity.type == 'CAMINHADA'}">
                                        <i class="activity-icon mt-2 bi bi-person-walking" data-bs-toggle="tooltip"
                                           data-bs-placement="top"
                                           data-bs-title="Caminhada"></i>
                                    </c:when>
                                    <c:when test="${activity.type == 'CICLISMO'}">
                                        <i class="activity-icon mt-2 fa-solid fa-person-biking"
                                           data-bs-toggle="tooltip" data-bs-placement="top"
                                           data-bs-title="Ciclismo"></i>
                                    </c:when>
                                    <c:when test="${activity.type == 'NATACAO'}">
                                        <i class="activity-icon mt-2 fa-solid fa-person-swimming"
                                           data-bs-toggle="tooltip" data-bs-placement="top"
                                           data-bs-title="Natação"></i>
                                    </c:when>
                                </c:choose></td>
                            <td class="pt-3">
                                <fmt:parseDate value="${activity.date}" pattern="yyyy-MM-dd" var="parsedDate"
                                               type="date"/>
                                <fmt:formatDate value="${parsedDate}" var="formattedDate" type="date"
                                                pattern="dd/MM/yyyy"/>
                                    ${formattedDate}
                            </td>
                            <td class="pt-3">${activity.distance}</td>
                            <td class="pt-3">${activity.duration}</td>
                            <td>
                                <a class="btn" data-bs-toggle="tooltip" data-bs-placement="top"
                                   data-bs-title="Editar"
                                   href="activityRegister?action=update&activity-id=${activity.id}">
                                    <i class="bi bi-pencil-fill"></i>
                                </a>
                                <a class="btn" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Excluir"
                                   href="activityRegister?action=delete&activity-id=${activity.id}">
                                    <i class="bi bi-trash-fill"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="container p-5 m-5">
                    <c:out value="Nenhuma atividade cadastrada."></c:out>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="scripts/home.js"></script>
<script src="https://kit.fontawesome.com/7f49ede8b9.js" crossorigin="anonymous"></script>
<script src="scripts/main.js" defer></script>
</body>
</html>