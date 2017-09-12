<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<a href="persona/add" class="btn btn-success">Añadir persona</a>
						</p>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<div class="row">
					<p>
						<a href="persona/add" class="btn btn-success">Añadir persona</a>
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
									<td>${persona.fechaNacimiento}</td>
									<td><a href="persona/edit?id=${persona.idpersonas}"
										class="btn btn-warning">Editar</a> <a
										href="persona/delete?id=${persona.idpersonas}"
										class="btn btn-danger">Eliminar</a></td>
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