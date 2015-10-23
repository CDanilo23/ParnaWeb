<%-- 
    Document   : mostrar
    Created on : 28/09/2015, 07:15:50 PM
    Author     : Administrador
--%>

<%@page import="java.util.List"%>
<%@page import="co.com.parna.Plan"%>
<%@page import="co.com.parna.MisPlanes"%>
<%@page import="co.com.parna.MiConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/miestilo.css"/>
        <title>Mis planes</title>
        <link href="css/parna-style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table cellspacing="0">
            <caption>Planes agregados al carrito</caption>

            <th>Nombre del parque</th>  
            <th>Imágen del parque</th> 
            <th>Costo plan temporada alta adultos</th> 
            <th>Costo plan temporada baja adultos</th>
            <th>Costo plan temporada alta niños</th>
            <th>Costo plan temporada baja niños</th>
            <th>Horario</th>
            <th>Mapa del del parque</th>
            <th></th>
                <%
                    if (session.getAttribute("miViaje") != null) {
                        for (Plan plan : ((MisPlanes) session.getAttribute("miViaje")).getMisProductos()) {

                            out.println("<tr>");
                            out.println("<td>" + plan.getNombre() + "</td>");
                            out.println("<td><img src='img/" + plan.getImagenParque() + "'><img></td>");
                            out.println("<td>" + plan.getCostoTempAltaAdultos() + "</td>");
                            out.println("<td>" + plan.getCostoTempBajaAdultos() + "</td>");
                            out.println("<td>" + plan.getCostoTempAltaNiños() + "</td>");
                            out.println("<td>" + plan.getCostoTempBajaNiños() + "</td>");
                            out.println("<td>" + plan.getHorario() + "</td>");
                            out.println("<td><img src='img/" + plan.getImagenMapa() + "'></img></td>");
                            out.println("<td><a href ='eliminar.jsp?id=" + plan.getId() + "'><img src='img/eliminar.png'></img></a></td>");
                            out.println("</tr>");
                        }
                    }
                %>
        </table>
        <div align='center'>
            <form action="guardarOrden.jsp" method="post" class="formulario">
                <table cellspacing=0 >
                    <tr>
                        <td>Nombre</td>
                        <td>
                            <input type="text" name="nombre">
                        </td>
                    </tr>
                    <tr>
                        <td>Direccion</td>
                        <td>
                            <input type=text name="direccion">
                        </td>
                    </tr>
                    <tr>
                        <td>Telefono</td>
                        <td>
                            <input type=text name="telefono">
                        </td>
                    </tr>
                    <tr>
                        <td>Ciudad</td>
                        <td>
                            <input type=text name="ciudad">
                        </td>
                    </tr>
                    <tr>
                        <td>Pais</td>
                        <td>
                            <input type=text name="pais">
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <input type="submit" value="Comprar" class='boton blue'>
                        </td>
                    </tr>

                </table>
            </form>
        </div>

        <footer class="footer">
            <p>
                Copyright © 2015 Cristian Danilo Ordoñez 
            </p>	
        </footer>
    </body>
</html>
