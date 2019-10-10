<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link  href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Para el Font-Awesome -->
    <link  href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <title>INICIO</title>
</head>
<body>
<h1>Listado Estudiantes</h1>
<!--Para mostrar usar el form que se quiere mostrar-->
<nav class="navbar navbar-light bg-light">
    <form class="form-inline">
        <button class="btn btn-outline-info " type="button">
        <a href="/">Listado estudiante</a>
        </button>
        <button class="btn btn-outline-dark" type="button">
            <a href="/NuevoEstudianteNavegacion">Nuevo estudiante</a>

        </button>
    </form>
</nav>


<div class="bg-primary text-center text-white">

<table class="table table-dark">

    <thead>

    <tr>

        <th scope="col">#</th>
        <th scope="col">MATRICULA</th>
        <th scope="col">NOMBRE</th>
        <th scope="col">APELLIDO</th>
        <th scope="col">TELEFONO</th>
        <th scope="col">EDITAR</th>
        <th scope="col">ELIMINAR</th>

    </tr>
    </thead>
    <tbody>
    <#if listadeestudiantes?size gt 0>
        <#assign hola=1 >

    <#list listadeestudiantes as estu>


    <tr>
        <td>${hola}</td>
        <td>${estu.matricula}</td>
        <td>${estu.nombre}</td>
        <td>${estu.apellido}</td>
        <td>${estu.telefono}</td>
        <td><button type="submit" class="btn btn-primary"> <a href="/editar/${estu.matricula}" style="color: azure"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button></td>
        <td><button type="submit"  class="btn btn-danger"> <a href="/delete/${estu.matricula}" style="color: azure"> <i class="fa fa-trash"> </i></a></button></td>

    </tr>
        <#assign hola++>
    </#list>


    </#if>

    </tbody>
</table>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>
</body>


</html>