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
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <div class="row my-3">
        <div class="col">
            <h4>Estatísticas das Atividades Físicas Realizadas</h4>
        </div>
    </div>
    <div class="row my-2">
        <div class="col-md-6 py-1">
            <div class="card">
                <h5 class="card-title m-4">Atividades por Tipo</h5>
                <div class="card-body">
                    <canvas id="chDonut1"></canvas>
                </div>
            </div>
        </div>
    </div>

</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js'></script>
<script type="text/javascript" src="scripts/statistics.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="scripts/home.js"></script>
<script src="https://kit.fontawesome.com/7f49ede8b9.js" crossorigin="anonymous"></script>
</body>
</html>