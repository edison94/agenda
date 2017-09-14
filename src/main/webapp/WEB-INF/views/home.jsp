<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Agenda online</title>
</head>

<body>
	<jsp:include page="templates/navbar.jsp"></jsp:include>
	<div class="container">
		<ul class="list-group">
			<li class="list-group-item justify-content-between">Personas<span
				class="badge badge-pill badge-primary text-center">0</span><a
				class="btn btn-primary" href="personas"
				role="button">Ir a lista <i class="fa fa-external-link"></i></a>
			</li>
			<li class="list-group-item justify-content-between">Empleados<span
				class="badge badge-pill badge-primary text-center">0</span><a
				class="btn btn-primary" href="empleados"
				role="button">Ir a lista <i class="fa fa-external-link"></i></a>
			</li>
			<li class="list-group-item justify-content-between">Categorías<span
				class="badge badge-pill badge-primary text-center">0</span><a
				class="btn btn-primary" href="categorias"
				role="button">Ir a lista <i class="fa fa-external-link"></i></a>
			</li>
			<li class="list-group-item justify-content-between">Departamentos<span
				class="badge badge-pill badge-primary text-center">0</span><a
				class="btn btn-primary" href="departamentos"
				role="button">Ir a lista <i class="fa fa-external-link"></i></a>
			</li>
		</ul>
	</div>
</body>
</html>