<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link  href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>EDITAR ESTUDIANTE</title>
</head>
<body>

<h2 style="font-family: 'Century Gothic'; padding: 10px"> <strong> Editar estudiante </strong></h2>
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
            <h4 class="modal-title w-100 font-weight-bold">EDITAR ESTUDIANTE</h4>

        </div>

        <div class="modal-body mx-6">

            <form method="post" action="/EditarUsuario" role="dialog">

                <div class="form-group">
                    <label for="matricula">Matricula</label>
                    <input type="text" class="form-control" id="matricula" name="matricula" aria-describedby="emailHelp" value="${estuLista.matricula}" required>
                    <small id="emailHelp" class="form-text text-muted">Eje: 2016-1615</small>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre(s)</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" value="${estuLista.nombre}" required>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido(s)</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Nombre" value="${estuLista.apellido}"required>
                </div>
                <div class="form-group">
                    <label for="telefono">Telefono</label>
                    <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Telefono/Celular" value="${estuLista.telefono} "required>
                </div>

                <button type="submit"  class="btn btn-primary">Actualizar</a>

                </button>

            </form>
        </div>

    </div>
</div>

</body>

</html>