<%-- 
    Document   : ListaUbicaciones
    Created on : 18 oct. 2020, 22:17:02
    Author     : vgd_9
--%>

<%@page import="com.mycompany.usuariostomcat.domain.Ubicacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <%@ include file="/WEB-INF/layout/menu.jspf" %>
            <% List<Ubicacion> ubicaciones = (List<Ubicacion>)mySession.getAttribute("listaUbicaciones"); %>
            
              <table>
            <caption>Lista de vehiculos</caption>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
             
              
              <% if(isAdmin){%>
                
                <th>Acciones</th>
              <%}%> 
                
              <th></th>
              
            </tr>
            
            <%
            
                
                
                for(Ubicacion ubicacion : ubicaciones){ %>
                    <tr>
                        
                        <td><%=ubicacion.getId()%></td>
                        <td><%=ubicacion.getNombre()%></td>
                        
                        
                        <% if(isAdmin){%>
                            <td>
                                <a href="http://localhost:8080/UsuariosTomcat/ModificaUbicacion?id=<%=ubicacion.getId()%>"><img src="img/refresh-button.png" alt="Basura para elminar empleado"/></a>
                                <a href="http://localhost:8080/UsuariosTomcat/EliminaUbicacion?id=<%=ubicacion.getId()%>"><img src="img/basurapeque.png" alt="Basura para elminar empleado"/></a>
                                                     
                            </td>
                       <%}%> 
                    </tr>
                 <%}%> 
        </table>

    </body>
</html>
