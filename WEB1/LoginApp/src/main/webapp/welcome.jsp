<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome</title>
<link rel='stylesheet' type='text/css' media='screen' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href="style.css">
</head>
<body class="d-flex justify-content-evenly p-2 mt-5">
	<div class="d-flex flex-column align-items-center main-container p-5 m-5">
		   <h6>Olá, <%= request.getAttribute("email") %>!</h6>
		   <h6>Você se conectou com sucesso.</h6>
     </div>
</body>
</html>