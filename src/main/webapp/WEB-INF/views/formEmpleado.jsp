<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Formulario de empleado</title>
</head>
<body>
	<div class="container">
		<h2>Formulario de empleado</h2>
		<form:form method="post" modelAttribute="empleado"
			accept-charset="UTF-8">
			<form:hidden path="idempleados"/>
			<div class="form-group">
				<form:label path="codEmpleado">Código empleado</form:label>:
				<form:input path="codEmpleado" class="form-control" />
				<div class="has-error">
					<form:errors path="codEmpleado" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="salario">Salario</form:label>:
				<form:input path="salario" class="form-control" />
				<div class="has-error">
					<form:errors path="salario" class="help-inline" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="fechaAlta">Fecha de Alta</form:label>:
				<form:input path="fechaAlta" class="form-control" type="date"/>
				<div class="has-error">
					<form:errors path="fechaAlta" class="help-inline" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>