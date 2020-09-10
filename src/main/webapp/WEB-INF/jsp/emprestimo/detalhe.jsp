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
	
		<form action="/emprestimo/incluir" method="post">
		
		    <div class="form-group">
		      <label for="usr">Solicitante:</label>
		      <select class="form-control" name="solicitante.id">
		      	<c:forEach var="s" items="${solicitantes}">
					<option value="${s.id}">${s.nome}</option>
				</c:forEach>
		      </select>
		    </div>
		
		    <div class="form-group">
		      <label for="usr">Descrição:</label>
		      <input type="text" class="form-control" name="descricao">
		    </div>
	
			<div class="form-group">
				<label for="usr">Produtos:</label>
				<c:if test="${not empty produtos}">
					<div class="form-check">
						<label class="form-check-label">
							<c:forEach var="p" items="${produtos}">
								<input type="checkbox" class="form-check-input" name="produtosIds" value="${p.id}"> ${p.descricao}<br>
							</c:forEach>
						</label>
					</div>
				</c:if>
				<c:if test="${empty produtos}">
				<label for="usr">Nenhum produto cadastrado!</label>
				</c:if>
			</div>
	
		<c:if test="${empty produtos || empty solicitantes}">
			<c:set var="disabled" value="disabled"/>
		</c:if>
		
	
	    <button ${disabled} type="submit" class="btn btn-primary">Gravar</button>
	  </form>
	</div>
</body>
</html>