<%-- 
    Document   : guardarOrden
    Created on : 22/10/2015, 01:00:36 AM
    Author     : YHOAN CUCAITA
--%>

<%@page import="co.com.parna.MisPlanes"%>
<%@page import="co.com.parna.MiConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String ciudad = request.getParameter("ciudad");
            String pais = request.getParameter("pais");

            MisPlanes misPlanes = (MisPlanes)session.getAttribute("miViaje");
            MiConexion miConexion = new MiConexion();
            miConexion.ingresarOrden(nombre, direccion, telefono, ciudad, pais, misPlanes);
            session.removeAttribute("miViaje");
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
