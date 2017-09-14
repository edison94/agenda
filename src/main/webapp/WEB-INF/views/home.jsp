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
			<li class="list-group-item justify-content-between">Categorias<span
				class="badge badge-pill badge-primary">0</span><a
				class="btn btn-primary" href="categorias"
				role="button">Ir a lista <i class="fa fa-external-link" aria-hidden="true"></i></a>
			</li>
			<li class="list-group-item justify-content-between">Departamentos<span
				class="badge badge-pill badge-primary">0</span><a
				class="btn btn-primary" href="departamentos"
				role="button">Ir a lista de Departamentos</a>
			</li>
			<li class="list-group-item justify-content-between">Empleados<span
				class="badge badge-pill badge-primary">0</span><a
				class="btn btn-primary" href="empleados"
				role="button">Ir a lista de Empleados</a>
			</li>
		</ul>
	</div>
</body>
</html>