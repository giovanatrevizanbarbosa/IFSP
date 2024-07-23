<%--
  Created by IntelliJ IDEA.
  User: giovanatb
  Date: 22/07/2024
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg sticky-top bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="homeServlet">IFitness</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" style="flex-grow: 0" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item mx-2">
                    <a class="nav-link" href="activityRegister">Nova Atividade</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="statistics">Estatísticas</a>
                </li>
                <li class="nav-item mx-2 dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">
                        ${sessionScope.user.name}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Minha Conta</a></li>
                        <li><a class="dropdown-item" href="logout">Sair</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>