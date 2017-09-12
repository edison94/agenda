%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form method="post" modelAttribute="telefonos" accept-charset="UTF-8">
  	<div class="form-group">
    	<form:label path="nombre">Numero telefono</form:label>
    	<form:input path="nombre" class="form-control" />
    	<div class="has-error">
			<form:errors path="nombre" class="form-control-feedback" />
		</div>
  	</div>
  	<  	<form:hidden path="iddirecciones"/>
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>