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
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categorias}" var="categoria">
								<tr>
									<th>${categoria.nombre}</th>
									<th>${categoria.descripcion}</th>
									<td data-page="categorias" class="text-right"><a
										href="categorias/get?id=${categoria.idcategorias}"
										class="btn btn-primary"><i class="fa fa-list"
											aria-hidden="true"></i></a> <a
										href="categorias/edit?id=${categoria.idcategorias}"
										class="btn btn-warning"><i class="fa fa-pencil-square-o"
											aria-hidden="true"></i> </a>
										<button class="btn btn-danger eliminar">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button> <input type="hidden" value="${ categoria.idcategorias }">
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