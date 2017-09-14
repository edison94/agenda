<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="templates/head.jsp"></jsp:include>
<title>Formulario de persona</title>
</head>
<body>
	<div class="container">
		<jsp:include page="templates/navbar.jsp"></jsp:include>
		<h2>Formulario de persona</h2>
		<form:form method="post" modelAttribute="persona"
			accept-charset="UTF-8">
			<form:hidden path="idpersonas" />
			<div class="form-group">
				<form:label path="nombre">Nombre</form:label>
				<form:input path="nombre" class="form-control"
					readonly="${readonly}" placeholder="Nombre" />
				<div class="has-error">
					<form:errors path="nombre" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="apellido1">Apellido 1</form:label>
				<form:input path="apellido1" class="form-control"
					readonly="${readonly}" placeholder="Primer apellido" />
				<div class="has-error">
					<form:errors path="apellido1" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="apellido2">Apellido 2</form:label><form:input path="apellido2" class="form-control"
					readonly="${readonly}" placeholder="Segundo apellido" />
				<div class="has-error">
					<form:errors path="apellido2" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="dni">DNI</form:label><form:input path="dni" class="form-control" readonly="${readonly}"
					placeholder="DNI" />
				<div class="has-error">
					<form:errors path="dni" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="fechaNacimiento">Fecha de nacimiento</form:label><form:input path="fechaNacimiento" class="form-control datepicker"
					readonly="${readonly}" placeholder="Fecha de nacimiento" />
				<div class="has-error">
					<form:errors path="fechaNacimiento" class="help-inline" />
				</div>
			</div>
			<c:choose>
				<c:when test="${readonly == 'true'}">
					<div class="form-group">
						<label>Teléfonos <a class="btn btn-primary invisible"
							href="telefonos/add?idpersonas=${persona.idpersonas}"
							role="button">Añadir</a>
						</label>
						<c:choose>
							<c:when test="${empty persona.telefonos}">
								<p>Aún no se añadió ningun teléfono</p>
							</c:when>
							<c:otherwise>
								<ul class="list-group">
									<c:forEach items="${persona.telefonos}" var="telefono">
										<li class="list-group-item justify-content-between">${telefono.telefono}<span
											class="invisible"><a class="btn btn-warning"
												href="telefonos/edit?id=${telefono.idtelefonos}"
												role="button">Modificar</a> <a class="btn btn-danger"
												href="telefonos/delete?id=${telefono.idtelefonos}"
												role="button">Eliminar</a></span>
										</li>
									</c:forEach>
								</ul>
							</c:otherwise>
						</c:choose>
					</div>

					<div class="form-group">
						<label>Direcciones <a class="btn btn-primary invisible"
							href="direccion/add?idpersonas=${persona.idpersonas}"
							role="button">Añadir</a>
						</label>
						<c:choose>
							<c:when test="${empty persona.direccion}">
								<p>Aún no se añadió ningun teléfono</p>
							</c:when>
							<c:otherwise>
								<ul class="list-group">
									<c:forEach items="${persona.direccion}" var="direccion">
										<li class="list-group-item justify-content-between">${direccion}<span
											class="invisible"><a class="btn btn-warning"
												href="direccion/edit?id=${direccion.iddirecciones}"
												role="button">Modificar</a> <a class="btn btn-danger"
												href="direccion/delete?id=${direccion.iddirecciones}"
												role="button">Eliminar</a></span>
										</li>
									</c:forEach>
								</ul>
							</c:otherwise>
						</c:choose>
					</div>
					<a class="btn btn-primary" href="/agenda/personas">Volver</a>

				</c:when>
				<c:otherwise>
					<button type="submit" class="btn btn-primary">Submit</button>
				</c:otherwise>
			</c:choose>

		</form:form>
	</div>

</body>
</html>