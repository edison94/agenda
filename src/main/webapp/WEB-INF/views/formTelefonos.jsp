<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Formulario de teléfono</title>
</head>
<body>
	<div class="container">
		<jsp:include page="templates/navbar.jsp"></jsp:include>
		<h2>Formulario de teléfono</h2>

		<form:form method="post" modelAttribute="telefono">
			<form:hidden path="idtelefonos" />
			<div class="form-group">
				<form:label path="telefono">Número</form:label>
				:
				<form:input path="telefono" class="form-control"
					placeholder="Número de teléfono" />
				<div class="has-error">
					<form:errors path="telefono" class="form-control-feedback" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>