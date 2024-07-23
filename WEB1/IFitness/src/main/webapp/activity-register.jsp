<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/stopwatch-20-solid.svg">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="css/errors.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <title>IFitness - Página de Cadastro de Atividade</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <div class="col-lg-6 offset-lg-3 col-sm-12 mt-5">
        <c:if test="${result == 'notRegistered'}">
            <div class="alert alert-danger alert-dismissible fade show mb-3" role="alert">
                <strong>Atividade não foi salva.</strong> Efetue o <a href="login.jsp"> login.</a>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${result == 'registered'}">
            <div class="alert alert-success alert-dismissible fade show mb-3" role="alert">
                <strong>Atividade salva com sucesso.</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <form action="activityRegister" method="post" id="form1">
            <c:choose>
                <c:when test="${activity == null}">
                    <h1 class="text-center">Nova atividade</h1>
                </c:when>
                <c:when test="${activity != null}">
                    <h1 class="text-center">Edição de atividade</h1>
                </c:when>
            </c:choose>

            <c:choose>
                <c:when test="${activity == null}">
                    <input type="hidden" name="id" value="0">
                </c:when>
                <c:when test="${activity != null}">
                    <input type="hidden" name="id" value="${activity.id}">
                </c:when>
            </c:choose>

            <div class="mb-3">
                <label for="type">Tipo de Atividade*</label>
                <select class="form-select" name="type" id="type" required="required">
                    <c:if test="${activity.type == null}">
                        <option value="" selected>Selecione</option>
                    </c:if>
                    <c:choose>
                        <c:when test="${activity.type == 'CAMINHADA'}">
                            <option value="CAMINHADA" selected>Caminhada</option>
                        </c:when>
                        <c:when test="${activity.type != 'CAMINHADA'}">
                            <option value="CAMINHADA">Caminhada</option>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${activity.type == 'CICLISMO'}">
                            <option value="CICLISMO" selected>Ciclismo</option>
                        </c:when>
                        <c:when test="${activity.type != 'CICLISMO'}">
                            <option value="CICLISMO">Ciclismo</option>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${activity.type == 'CORRIDA'}">
                            <option value="CORRIDA" selected>Corrida</option>
                        </c:when>
                        <c:when test="${activity.type != 'CORRIDA'}">
                            <option value="CORRIDA">Corrida</option>
                        </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${activity.type == 'NATACAO'}">
                            <option value="NATACAO" selected>Natação</option>
                        </c:when>
                        <c:when test="${activity.type != 'NATACAO'}">
                            <option value="NATACAO">Natação</option>
                        </c:when>
                    </c:choose>
                </select>
            </div>

            <div class="mb-3">
                <label for="date">Data*</label>
                <input class="form-control" type="date" name="date" id="date" required="required"
                       value="${activity.date}">
            </div>


            <div class="mb-3">
                <label for="distance">Distância (KM)*</label>
                <input class="form-control" type="number" name="distance" id="distance" step="0.1" min="0.1"
                       required="required" value="${activity.distance}">
            </div>

            <div class="mb-3">
                <label for="duration">Duração (Minutos)*</label>
                <input class="form-control" type="number" name="duration" id="duration" step="1" min="1"
                       required="required" value="${activity.duration}">
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
<script src="scripts/main.js" defer></script>
</body>
</html>