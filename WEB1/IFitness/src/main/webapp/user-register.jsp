<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="css/errors.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <title>IFitness - Página de Cadastro de Usuário</title>
</head>
<body>
<div class="container">
    <div class="col-lg-6 offset-lg-3 col-sm-12 mt-5">
        <c:if test="${result == 'notRegistered'}">
            <div class="alert alert-danger alert-dismissible fade show mb-3" role="alert">
                <strong>E-mail já cadastrado.</strong> Tente fazer <a href="login.jsp"> login.</a>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <form action="userRegister" method="post" id="form1">
            <h1 class="text-center">Cadastre-se</h1>

            <div class="mb-3">
                <label for="name">Nome completo*</label>
                <input class="form-control" type="text" name="name" id="name" minlength="3" maxlength="50"
                       required="required">
                <span id="0"></span>
            </div>

            <div class="mb-3">
                <label for="email">E-mail*</label>
                <input class="form-control" type="email" name="email" id="email" required="required">
                <span id="1"></span>
            </div>

            <div class="mb-3">
                <label for="password">Senha*</label>
                <input class="form-control" type="password" name="password" id="password" minlength="6" maxlength="12"
                       required="required">
                <span id="2"></span>
            </div>

            <div class="mb-3">
                <label for="confirmPassword">Confirmação de Senha*</label>
                <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" minlength="6"
                       maxlength="12" required="required">
                <span id="3"></span>
            </div>

            <div class="mb-3">
                <label for="dateOfBirth">Data de Nascimento*</label>
                <input class="form-control" type="date" name="dateOfBirth" id="dateOfBirth" max="2012-12-31"
                       required="required">
                <span id="4"></span>
            </div>

            <div class="mb-3">
                <label for="gender">Gênero</label>
                <select class="form-select" name="gender" id="gender" required="required">
                    <option value="" selected>Selecione</option>
                    <option value="MASCULINO">Masculino</option>
                    <option value="FEMININO">Feminino</option>
                    <option value="OUTRO">Outro</option>
                    <option value="PREFIRO_NAO_DIZER">Prefiro não dizer</option>
                </select>
                <span id="5"></span>
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Salvar</button>
            </div>

            <div class="mb-3">
                <a href="login.jsp" class="btn btn-secondary">Voltar para o Login</a>
            </div>

        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="scripts/user-register.js"></script>
</body>
</html>