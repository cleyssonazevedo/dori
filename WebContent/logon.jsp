<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">    
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Bolao</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="resources/css/logon.css" />
<link rel="stylesheet" href="resources/css/default.css" />

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		if(session.getAttribute("login") != null) {
			response.sendRedirect("bolao.jsp");
		}	
	%>

	<jsp:useBean id="error" scope="session" class="java.lang.String"></jsp:useBean>
	<div class="container">
      <form action="login" method="POST" class="form-signin" id="logon" name="logon">
        <h2 class="form-signin-heading">Bolão do DORI</h2>
        <label for="username" class="sr-only">Usuário</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Usuário" required autofocus>
        <label for="password" class="sr-only">Senha</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Senha" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      </form>
      <div class="error"><%=error %></div>
    </div> <!-- /container -->
    
    <%
    	// Limpar mensagem de erro para não ficar reaparecendo caso a página seja atualizada!
    	session.removeAttribute("error");
    %>
</body>
</html>