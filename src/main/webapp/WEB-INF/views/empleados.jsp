<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
							<a href="/agenda/empleados/add" class="btn btn-success">Añadir
								empleado</a>
						</p>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<div class="row">
					<p>
						<a href="/agenda/empleados/add" class="btn btn-success">Añadir
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
									<td>${empleado.personas.apellido1}
										${empleado.personas.apellido2}</td>
									<td>${empleado.salario}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy"
											value="${empleado.fechaAlta}" /></td>
									<td data-page="empleados" class="text-right"><a
										href="empleados/get?id=${empleado.idempleados}"
										class="btn btn-primary"><i class="fa fa-list"
											aria-hidden="true"></i></a> <a
										href="empleados/edit?id=${empleado.idempleados}"
										class="btn btn-warning"><i class="fa fa-pencil-square-o"
											aria-hidden="true"></i></a>
											<button class="btn btn-danger eliminar">
												<i class="fa fa-trash" aria-hidden="true"></i>
											</button> <input type="hidden" value="${ empleado.idempleados }">
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