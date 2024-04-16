<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/person-walking.svg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="css/errors.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <title>IFitness - Página de Cadastro de Atividade</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="homeServlet">IFitness</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="homeServlet">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="col-lg-6 offset-lg-3 col-sm-12 mt-5">
        <c:if test="${result == 'notRegistered'}">
            <div class="alert alert-danger alert-dismissible fade show mb-3" role="alert">
                <strong>Atividade não cadastrada.</strong> Efetue o <a href="login.jsp"> login.</a>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${result == 'registered'}">
            <div class="alert alert-success alert-dismissible fade show mb-3" role="alert">
                <strong>Atividade cadastrada com sucesso.</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <form action="activityRegister" method="post" id="form1">
            <h1 class="text-center">Nova atividade</h1>

            <div class="mb-3">
                <label for="type">Tipo de Atividade*</label>
                <select class="form-select" name="type" id="type" required="required">
                    <option value="" selected>Selecione</option>
                    <option value="CAMINHADA">Caminhada</option>
                    <option value="CICLISMO">Ciclismo</option>
                    <option value="CORRIDA">Corrida</option>
                    <option value="NATACAO">Natação</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="date">Data*</label>
                <input class="form-control" type="date" name="date" id="date" required="required">
            </div>


            <div class="mb-3">
                <label for="distance">Distância (KM)*</label>
                <input class="form-control" type="number" name="distance" id="distance" step="0.1" min="0.1"
                       required="required">
            </div>

            <div class="mb-3">
                <label for="duration">Duração (Minutos)*</label>
                <input class="form-control" type="number" name="duration" id="duration" step="1" min="1"
                       required="required">
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Salvar</button>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>