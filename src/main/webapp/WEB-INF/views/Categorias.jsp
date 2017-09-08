<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Categorias</title>
        <meta charset="UTF-8">
        <link href="css/estilos.css" rel="stylesheet" type="text/css" />        
    </head>

    <body>
        <div id="contenedor">
            <h2>Listado de Categorias</h2>

            <form:form method="POST" commandName="command">
                <form:errors path="*" cssClass="destacado" element="div"/>
                <table>
                    <tr>
                        <td>Nombre : </td>
                        <td>Descripcion : </td>
                        <td><form:input path="mail" /></td>
                        <td><form:errors path="mail" cssClass="destacado" /></td>
                    </tr>
                    <tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" value="<< Ir al paso 2" name="_target1" />
                            <input type="submit" value="Finalizar" name="_finish" />
                            <input type="submit" value="Cancel" name="_cancel" />
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>

    </body>
</html>