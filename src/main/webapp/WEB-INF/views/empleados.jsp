<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Listado de empleados</title>
</head>
<body>
	<div class="container">
		<jsp:include page="templates/navbar.jsp"></jsp:include>
		<h2>Listado de empleados</h2>
		<c:choose>
			<c:when test="${empty empleados}">
				<section class="jumbotron text-center">
					<div class="container">
						<h1 class="jumbotron-heading">No hay empleados</h1>
						<p>
							<a href="empleados/add" class="btn btn-success">Añadir
								empleado</a>
						</p>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<div class="row">
					<p>
						<a href="empleados/add" class="btn btn-success">Añadir
							empleado</a>
					</p>
					<table class="table table-hover">
						<thead class="table-info">
							<tr>
								<th>Código</th>
								<th>Nombre</th>
								<th>Apellidos</th>
								<th>Salario</th>
								<th>Fecha de alta</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${empleados}" var="empleado">
								<tr>
									<td>${empleado.codEmpleado}</td>
									<td>${empleado.personas.nombre}</td>
									<td>${empleado.personas.apellido1} ${empleado.persona.apellido2}</td>
									<td>${empleado.salario}</td>
									<td>${empleado.fechaAlta}</td>
									<td><a href="empleados/edit?id=${empleado.idempleados}"
										class="btn btn-warning">Editar</a> <a
										href="empleados/delete?id=${empleado.idempleados}"
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