<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link  href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>NUEVO ESTUDIANTE</title>
</head>
<body>

<h2 style="font-family: 'Century Gothic'; padding: 10px"> <strong> Crear estudiante </strong></h2>
<!--Para mostrar usar el form que se quiere mostrar-->
<nav class="navbar navbar-light bg-light">
    <form class="form-inline">
        <button class="btn btn-outline-info " type="button">
            <a href="/">Listado estudiante</a>
        </button>&nbsp;
        <button class="btn btn-outline-dark" type="button">
            <a href="/NuevoEstudianteNavegacion">Nuevo estudiante</a>
        </button>
    </form>
</nav>

<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-header text-center">
            <h4 class="modal-title w-100 font-weight-bold">NUEVO ESTUDIANTE</h4>

        </div>
        <div class="modal-body mx-6">
            <form method="post" action="/NuevoEstudiante" role="dialog">

                <div class="form-group">
                    <label for="exampleInputEmail1">Matrícula</label>
                    <input type="text" class="form-control" id="matricula" name="matricula" aria-describedby="emailHelp"  required>
                    <small id="emailHelp" class="form-text text-muted">Eje: 2016-1615</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Nombre(s)</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Apellido(s)</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Nombre" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Teléfono</label>
                    <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Telefono/Celular" required>
                </div>

                <button type="submit" value="crear" class="btn btn-primary"> <strong>Crear</strong>

                </button>
            </form>
        </div>
    </div>
</div>
</body>







</html>