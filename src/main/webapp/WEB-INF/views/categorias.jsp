<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Listado de categorías</title>
</head>
<body>
	<jsp:include page="templates/navbar.jsp"></jsp:include>
	<div class="container">
		<h2>Listado de categorías</h2>
		<c:choose>
			<c:when test="${empty categorias}">
				<section class="jumbotron text-center">
					<div class="container">
						<h1 class="jumbotron-heading">No hay categorías</h1>
						<p>
							<a href="categorias/add" class="btn btn-success">Añadir
								categoría</a>
						</p>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<div class="row">
					<p>
						<a href="categorias/add" class="btn btn-success">Añadir
							categoría</a>
					</p>
					<table class="table table-hover">
						<thead class="table-info">
							<tr>
								<th>Nombre</th>
								<th>Descripción</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categorias}" var="categoria">
								<tr>
									<th>${categoria.nombre}</th>
									<th>${categoria.descripcion}</th>
									<td><a href="categorias/edit?id=${categoria.idcategorias}"
										class="btn btn-warning">Editar</a> <a
										href="categorias/delete?id=${categoria.idcategorias}"
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