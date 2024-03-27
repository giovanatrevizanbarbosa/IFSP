<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <title>IFitness - Página de Login</title>
</head>
<body>
<div class="container">
    <form action="login" method="post">
        <div class="col-lg-4 offset-lg-4 col-sm-12">
            <h1 class="text-center">Login</h1>

            <div class="input-group mb-3">
                    <span class="input-group-text">
                        <img class="me-2" alt="E-mail" src="img/envelope-at-fill.svg" width="16" height="16">
                        <input class="form-control" type="email" name="email" id="email" placeholder="E-mail"
                               required="required">
                    </span>
            </div>

            <div class="input-group mb-3">
                    <span class="input-group-text">
                        <img class="me-2" alt="Senha" src="img/key-fill.svg" width="16" height="16">
                        <input class="form-control" type="password" name="password" id="password" placeholder="Senha"
                               required="required">
                    </span>
            </div>

            <div class="mb-3">
                <button class="btn btn-primary" type="submit">Login</button>
            </div>

            <div class="mb-3">
                <a href="user-register.jsp" class="btn btn-secondary">Cadastrar-se</a>
            </div>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
