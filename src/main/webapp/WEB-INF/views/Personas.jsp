<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="templates/head.jsp"></jsp:include>
<title>Listado de personas</title>
</head>
<body>
	<jsp:include page="templates/navbar.jsp"></jsp:include>
	<div class="container">
		<h2>Listado de personas</h2>
		<c:choose>
			<c:when test="${empty personas}">
				<section class="jumbotron text-center">
					<div class="container">
						<h1 class="jumbotron-heading">No hay personas</h1>
						<p>
							<a href="/agenda/personas/add" class="btn btn-success">Añadir persona</a>
						</p>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<div class="row">
					<p>
						<a href="/agenda/personas/add" class="btn btn-success">Añadir persona</a>
					</p>
					<table class="table table-hover">
						<thead class="table-info">
							<tr>
								<th>Nombre</th>
								<th>Apellidos</th>
								<th>DNI</th>
								<th>Fecha de nacimiento</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${personas}" var="persona">
								<tr>
									<td>${persona.nombre}</td>
									<td>${persona.apellido1} ${persona.apellido2}</td>
									<td>${persona.dni}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${persona.fechaNacimiento}" /></td>
									<td class="text-right" data-page="personas"><a
										href="personas/get?id=${persona.idpersonas}"
										class="btn btn-primary"><i class="fa fa-list"
											aria-hidden="true"></i></a> <a
										href="personas/edit?id=${persona.idpersonas}"
										class="btn btn-warning"><i class="fa fa-pencil-square-o"
											aria-hidden="true"></i> </a>
										<button class="btn btn-danger eliminar">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button> <input type="hidden" value="${ persona.idpersonas }">
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>