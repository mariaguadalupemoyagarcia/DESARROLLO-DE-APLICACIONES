

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Material</title>
    </head>
    <body>
        <form action="MaterialController" method="post">
            <fieldset>
                <legend>Formulario de Material</legend>

                <div> 
                    <label for="idMaterial"> Id Material:</label>
                    <input type="text" name="idMaterial" value="${material.idMaterial}"
                           readonly="readonly" placeholder="Id de material" />
                </div>

                <div> 
                    <label for="nombre"> Nombre:</label>
                    <input type="text" name="nombre" value="${material.nombre}"
                           placeholder="Nombre del material" />
                </div>

                <div> 
                    <label for="precio"> Precio:</label>
                    <input type="text" name="precio" value="${material.precio}"
                           placeholder="Precio del material" />
                </div>

                <div> 
                    <label for="curso"> Comisión:</label>
                    <input type="text" name="comision" value="${material.comision}"
                           placeholder="comisión del material" />
                </div>

                <div> 
                    <label for="existenciaMin"> Existencia Minima:</label>
                    <input type="text" name="existenciaMin" value="${material.existenciaMin}"
                           placeholder="Existencia minina" />
                </div>
                
                <div> 
                    <label for="existenciaMax"> Existencia Maxima:</label>
                    <input type="text" name="existenciaMax" value="${material.existenciaMax}"
                           placeholder="Existencia maxima" />
                </div>
                     

                <div> 
                    <input type="submit" value="Guardar"/>
                </div>

            </fieldset>
        </form>
    </body>
</html>
