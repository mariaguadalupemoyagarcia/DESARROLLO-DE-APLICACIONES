

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Materiales</title>
    </head>
    <body>
        <table>
            <thead> 
            <tr>
                <th> Id de materia:</th>
                <th>Nombre:</th>
                <th>Precio</th>
                <th>Comisión:</th>
                <th>Existencia Minima:</th>
                 <th>Existencia Maxima:</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="material" items="${material}">
                    <tr>
                        <td>${material.idMaterial}</td>
                        <td>${material.nombre}</td>
                        <td>${material.precio}</td>
                        <td>${material.comision}</td>
                        <td>${material.existenciaMin}</td>
                         <td>${material.existenciaMax}</td>
                        <td><a href="MaterialController?action=cambiar&idMaterial=${material.idMaterial}">Cambiar</a></td>
                        <td><a href="MaterialController?action=borrar&idMaterial=${material.idMaterial}">Borrar</a></td>
                    </tr>                    
                </c:forEach>
            </tbody>
            
        </table>
        <p>
            <a href="MaterialController?action=agregar">
                Agregar material
            </a>
        </p>
    </body>
</html>
