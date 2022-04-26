<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title> CRAutos | Editar auto </title>
    </head>
    <body style="background-color: #474C5B;">
        <%
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            int anno = Integer.parseInt(request.getParameter("anno"));
            String estilo = request.getParameter("estilo");
        %>

        <!-- aquí se crea la pantalla de editar donde se puede borrar también -->
        <div class="container">
            <div class="card text-white bg-dark mb-3" style="margin-top: 50px;">
                <div class="card-header">
                    Editar auto
                </div>
                <div class="card text-white bg-dark mb-3">
                    <form action="updateAuto.jsp">
                        <div style="width: 100px;" value="<%=marca%>">
                            Marca
                            <select name="marcas">
                                <option> Ford </option>
                                <option> Nissan </option>
                                <option> Toyota </option>
                                <option> Hyundai </option>
                                <option> KIA </option>
                                <option> Mitsubishi </option>
                                <option> Chevrolet </option>
                                <option> Suzuki </option>
                            </select>
                        </div> <br>
                        <div class="mb-3">
                            <label class="form-label"> Modelo </label>
                            <input type="text" class="form-control" name="txtmodelo" value="<%=modelo%>" readonly>
                        </div>
                        <div class="mb-3">
                            <label class="form-label"> Año </label>
                            <input type="text" class="form-control" name="txtanno" value="<%=anno%>">
                        </div>    
                        <div style="width: 100px;" value="<%=estilo%>">
                            Estilo
                            <select name="estilos">
                                <option> 4x4 </option>
                                <option> Pick-Up </option>
                                <option> 2 puertas </option>
                                <option> 4 puertas </option>
                                <option> Automóvil </option>
                                <option> Sedan </option>
                                <option> Urbano </option>
                                <option> Subcompacto </option>
                                <option> Familiar </option>
                                <option> Descapotable </option>
                            </select>
                        </div> <br>
                        <button id="btnEdit" class="btn btn-primary" type="submit"> Actualizar </button>       
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                            Vender auto
                        </button>
                        <button class="btn btn-info" href='autosServlet'> Mostrar autos </button>                           
                    </form>                                      
                </div>
            </div>
        </div>

        <!-- Modal para que el usuario marque si está seguro de que vendió el auto -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"> Vendido </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        El auto <%=modelo%> se vendió? 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"> No </button>
                        <button onclick="deleteAuto(<%=anno%>)" type="button" class="btn btn-primary"> Sí </button>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function deleteAuto(anno)
            {
                window.location.href = 'deleteAuto.jsp?anno=' + anno;
            }
        </script>
    </body>
</html>
