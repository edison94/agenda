<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Formulario de departamento</title>
</head>
<body>
	<div class="container">
		<jsp:include page="templates/navbar.jsp"></jsp:include>
		<h2>Formulario de departamento</h2>

		<form:form method="post" modelAttribute="departamento">
			<form:hidden path="iddepartamento" />
			<div class="form-group">
				<form:label path="nombre">Nombre</form:label>
				:
				<form:input path="nombre" class="form-control"
					placeholder="Nombre del departamento" />
				<div class="has-error">
					<form:errors path="nombre" class="form-control-feedback" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>