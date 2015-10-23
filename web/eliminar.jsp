<%-- 
    Document   : eliminar
    Created on : 10/10/2015, 06:45:01 PM
    Author     : Cristian Danilo Ordoñez
--%>

<%@page import="co.com.parna.MisPlanes"%>
<%@page import="co.com.parna.Plan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Integer id = Integer.parseInt(request.getParameter("id"));
            MisPlanes misPlanes = (MisPlanes) session.getAttribute("miViaje");
            for (Plan plan : misPlanes.getMisProductos()) {
                if (plan.getId().equals(id)) {
                    misPlanes.removerProducto(plan);
                    break;
                }
            }
            response.sendRedirect("mostrar.jsp");
        %>
    </body>
</html>
