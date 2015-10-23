<%-- 
    Document   : datos
    Created on : 18/09/2015, 06:54:32 PM
    Author     : Administrador
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
            String nombreParque = (String) request.getParameter("nombre");
            String imgParque = (String) request.getParameter("imgParque");
            Double costoAdultoTempAlta = Double.parseDouble(request.getParameter("costo1"));
            Double costoAdultoTempBaja = Double.parseDouble(request.getParameter("costo2"));
            Double costoNiñoTempAlta = Double.parseDouble(request.getParameter("costo3"));
            Double costoNiñoTempBaja = Double.parseDouble(request.getParameter("costo4"));
            String horario = (String) request.getParameter("horario");
            String imgMapa = (String) request.getParameter("imgMapa");
            Plan plan = new Plan();
            plan.setId(id);
            plan.setNombre(nombreParque);
            plan.setImagenParque(imgParque);
            plan.setCostoTempAltaAdultos(costoAdultoTempAlta);
            plan.setCostoTempBajaAdultos(costoAdultoTempBaja);
            plan.setCostoTempAltaNiños(costoNiñoTempAlta);
            plan.setCostoTempBajaNiños(costoNiñoTempBaja);
            plan.setHorario(horario);
            plan.setImagenMapa(imgMapa);
            MisPlanes misPlanes = (MisPlanes)session.getAttribute("miViaje");
            if(misPlanes==null){
                  misPlanes = new MisPlanes();
            }
            misPlanes.agregarPlan(plan);
            session.setAttribute("miViaje",misPlanes);
            response.sendRedirect("index.jsp");
        %>
    </body>

</html>
