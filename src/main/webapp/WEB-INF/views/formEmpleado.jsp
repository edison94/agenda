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
		<jsp:include page="templates/navbar.jsp"></jsp:include>
		<h2>Formulario de empleado</h2>
		<form:form method="post" modelAttribute="empleado"
			accept-charset="UTF-8">
			<form:hidden path="personas.idpersonas"/>
			<div class="form-group">
				<form:label path="personas.nombre">Nombre</form:label>:
				<form:input path="personas.nombre" class="form-control" placeholder="Nombre"/>
				<div class="has-error">
					<form:errors path="personas.nombre" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="personas.apellido1">Apellido 1</form:label>:
				<form:input path="personas.apellido1" class="form-control" placeholder="Primer apellido"/>
				<div class="has-error">
					<form:errors path="personas.apellido1" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="personas.apellido2">Apellido 2</form:label>:
				<form:input path="personas.apellido2" class="form-control" placeholder="Segundo apellido"/>
				<div class="has-error">
					<form:errors path="personas.apellido2" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="personas.dni">DNI</form:label>:
				<form:input path="personas.dni" class="form-control" placeholder="DNI"/>
				<div class="has-error">
					<form:errors path="personas.dni" class="form-control-feedback"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="personas.fechaNacimiento">Fecha de nacimiento</form:label>:
				<form:input path="personas.fechaNacimiento" class="form-control datepicker" placeholder="Fecha de nacimiento"/>
				<div class="has-error">
					<form:errors path="personas.fechaNacimiento" class="help-inline" />
				</div>
			</div>
			
			<form:hidden path="idempleados"/>
			<div class="form-group">
				<form:label path="codEmpleado">Código empleado</form:label>:
				<form:input path="codEmpleado" class="form-control" placeholder="Código empleado"/>
				<div class="has-error">
					<form:errors path="codEmpleado" class="form-control-feedback" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="salario" type="number">Salario</form:label>:
				<form:input path="salario" class="form-control" type="number" placeholder="Salario"/>
				<div class="has-error">
					<form:errors path="salario" class="help-inline" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="fechaAlta">Fecha de alta</form:label>:
				<form:input path="fechaAlta" class="form-control datepicker" placeholder="Fecha de alta"/>
				<div class="has-error">
					<form:errors path="fechaAlta" class="help-inline" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="departamentos.iddepartamento">Departamento</form:label>:
				<form:select path="departamentos.iddepartamento" class="form-control" placeholder="Selecciona un departamento">
	    			<option>Selecciona un departamento</option>
	    			<form:options items="${departamentos}" itemLabel="nombre" itemValue="iddepartamento"/>
				</form:select>
				<div class="has-error">
					<form:errors path="departamentos.iddepartamento" class="form-control-feedback" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="categorias.idcategorias">Categoría</form:label>:
				<form:select path="categorias.idcategorias" class="form-control" placeholder="Selecciona una categoría">
					<option>Selecciona una categoría</option>
	    			<form:options items="${categorias}" itemLabel="nombre" itemValue="idcategorias" />
				</form:select>
				<div class="has-error">
					<form:errors path="categorias.idcategorias" class="form-control-feedback" />
				</div>
			</div>
			
			<div class="form-group">
				<label>Teléfonos: <a class="btn btn-primary invisible"
					href="telefonos/add?idpersonas=${empleado.personas.idpersonas}"
					role="button">Añadir</a>
				</label>
					<c:choose>
						<c:when test="${empty empleado.personas.telefonos}">
							<p>Aún no se añadió ningun teléfono</p>
						</c:when>
						<c:otherwise>
							<ul class="list-group">
								<c:forEach items="${empleado.personas.telefonos}" var="telefono">
									<li class="list-group-item justify-content-between">${telefono.telefono}<span class="invisible"><a
											class="btn btn-warning"
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
				<label>Direcciones: <a class="btn btn-primary invisible"
					href="direccion/add?idpersonas=${empleado.personas.idpersonas}"
					role="button">Añadir</a>
				</label>
					<c:choose>
						<c:when test="${empty empleado.personas.direccion}">
							<p>Aún no se añadió ningun teléfono</p>
						</c:when>
						<c:otherwise>
							<ul class="list-group">
								<c:forEach items="${empleado.personas.direccion}" var="direccion">
									<li class="list-group-item justify-content-between">${direccion}<span class="invisible"><a
											class="btn btn-warning"
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
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>