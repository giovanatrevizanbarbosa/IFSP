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
    <title>IFitness - Estatísticas</title>
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
                    <a class="btn btn-primary" href="activity-register.jsp">Nova Atividade</a>
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
                <button class="btn btn-outline-success" type="button">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <i id="toggle-theme" class="btn bi bi-moon-fill"></i>
    <div class="center col-lg-12 col-sm-12 mt-5 text-center">
        <h2>Em breve!</h2>
    </div>
</div>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="scripts/home.js"></script>
<script src="https://kit.fontawesome.com/7f49ede8b9.js" crossorigin="anonymous"></script>
<script src="scripts/main.js"></script>
</body>
</html>