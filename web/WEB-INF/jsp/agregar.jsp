<%-- 
    Document   : agregar
    Created on : 14/02/2020, 11:42:23 AM
    Author     : rolo_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Agregar</title>
    </head>
    <body>
        <div class="container mt-6 col-lg-6">
            <div class="card border-info">
                <div class="card-header">
                    <h4>Nuevo Usuario</h4>
                </div>
                <div class="card-body">
                    <form method="POST">
                        <label>Nombre</label>
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre" required>
                        <br>
                         <label>Apellido</label>
                        <input type="text" name="apellido" class="form-control" placeholder="Apellidos" required>
                        <br>
                        <label>Puesto</label>
                        <input type="text" name="puesto" class="form-control" placeholder="Puesto" required>
                        <br>
                        <label>Correo Institucional Actual</label>
                        <input type="email" name="correo" class="form-control" placeholder="alguien@algo.com" required>
                        <br>
                        <input type="submit" value="Agregar" class="btn btn-success">
                        <a href="index.htm">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
