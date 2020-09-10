<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>AppEmprestimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<div class="container-fluid" style="margin-top:80px">		
			<c:import url="/WEB-INF/jsp/header.jsp"/>
		</div>			
	
		<h3>Empréstimos: ${operacao}</h3>
	
	    <div class="form-group">
	      <label for="usr">Solicitante:</label>
	      <label for="usr">${emprestimo.solicitante.nome}</label>
	    </div>
	
	    <div class="form-group">
	      <label for="usr">Descrição:</label>
	      <label for="usr">${emprestimo.descricao}</label>
	    </div>

		<div class="form-group">
			<label for="usr">Produtos:</label>

			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>DESCRIÇÃO</th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="p" items="${emprestimo.produtos}">
				      <tr>
				        <td>${p.id}</td>
				        <td>${p}</td>
				      </tr>
			      </c:forEach>
			    </tbody>
			</table>	
		</div>	
	</div>
</body>
</html>