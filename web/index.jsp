<%-- 
    Document   : index
    Created on : 18/10/2015, 10:03:17 AM
    Author     : Cristian Danilo Ordoñez
--%>

<%@page import="co.com.parna.MisPlanes"%>
<%@page import="co.com.parna.Plan"%>
<%@page import="co.com.parna.MiConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Parna Cloud Web</title><!--Titulo de mi web-->
        <meta charset="utf-8" />
        <link href="css/parna-style.css" rel="stylesheet" type="text/css">
        <script  type="text/javascript" src="js/modernizr.js"></script>
    </head>
    <body>

        <header id=""><!--Cabecera principal de mi sitio-->
            
                <!--<a href="#">-->
                <br>
                <div class='titulo' align="center" >
                    
                     <img id='banner' src="img/banner.png"/>
                </div>    
                    
                <!--</a>-->
            <!--URL de Mi Logo-->
            <nav class="menu"><!--Menu-->
                <ul>
                    <li><a href="index.html">Inicio</a></li>
                    <li><a href="mostrar.jsp">Añadidos al carrito</a></li>
                    <li><a href="#">Reportes</a></li>
                    <li><a href="#">Mis Servicios</a></li>
                    <li><a href="#">Contactenos</a></li>
                    <li><a href="#">Mi Empresa</a></li>
                </ul>
            </nav>
        </header>
        <!--Contenido del sitio-->
        <div class=""><!--Slider-->
            <img src="">
        </div>
        <div>
            <section class="">
                <article class="">
                    <table cellspacing="0">
                        <br>    
                        <caption><h1>Catálogo de planes turisticos</h1></caption>
                        <br>
                        <tr>
                            <th>Nombre del parque</th>  
                            <th>Imágen del parque</th> 
                            <th>Costo plan temporada alta adultos</th> 
                            <th>Costo plan temporada baja adultos</th>
                            <th>Costo plan temporada alta niños</th>
                            <th>Costo plan temporada baja niños</th>
                            <th>Horario</th>
                            <th>Mapa del del parque</th>
                            <th></th>
                        </tr>
                        <%
                            co.com.parna.MiConexion miConexion = new MiConexion();

                            MisPlanes miCatalogo = miConexion.consultarDatos();

                            for (Plan plan : miCatalogo.getMisProductos()) {
                                out.println("<tr>");
                                out.println("<td>" + plan.getNombre() + "</td>");
                                out.println("<td><img src='img/" + plan.getImagenParque() + "'><img></td>");
                                out.println("<td>" + plan.getCostoTempAltaAdultos() + "</td>");
                                out.println("<td>" + plan.getCostoTempBajaAdultos() + "</td>");
                                out.println("<td>" + plan.getCostoTempAltaNiños() + "</td>");
                                out.println("<td>" + plan.getCostoTempBajaNiños() + "</td>");
                                out.println("<td>" + plan.getHorario() + "</td>");
                                out.println("<td><img src='img/" + plan.getImagenMapa() + "'></img></td>");
                                out.println("<td><a href ='datos.jsp?id=" + plan.getId() 
                                                            + "&nombre=" + plan.getNombre()
                                                            + "&imgParque=" + plan.getImagenParque()
                                                            + "&costo1=" + plan.getCostoTempAltaAdultos()
                                                            + "&costo2=" + plan.getCostoTempBajaAdultos()
                                                            + "&costo3=" + plan.getCostoTempAltaNiños()
                                                            + "&costo4=" + plan.getCostoTempBajaNiños()
                                                            + "&horario=" + plan.getHorario()
                                                            + "&imgMapa=" + plan.getImagenMapa()
                                                            + "'><img src='img/carrito.png'></img></a></td>");
                                out.println("</tr>");
                            }
                        %>

                    </table>
                </article>
            </section>
            <aside class="sidebar">
                <h1></h1>
                <p></p>
                <img id="img1" src=""/>
                <img src=""/>

            </aside>
        </div>
        <footer class="footer">
            <p>
                Copyright © 2015 Cristian Danilo Ordoñez 
            </p>	
        </footer>
    </body>
</html>
