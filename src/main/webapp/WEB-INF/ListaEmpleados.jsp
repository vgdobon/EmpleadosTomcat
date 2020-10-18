<%-- 
    Document   : ListaEmpleados
    Created on : 18 oct. 2020, 0:00:09
    Author     : vgd_9
--%>

<%@page import="com.mycompany.usuariostomcat.domain.Ubicacion"%>
<%@page import="com.mycompany.usuariostomcat.domain.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.usuariostomcat.controller.ListaEmpleados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
        <%@ include file="/WEB-INF/layout/menu.jspf" %>
        <% List<Empleado> empleados = (List<Empleado>) mySession.getAttribute("listaEmpleados");
           List<Ubicacion> ubicaciones = (List<Ubicacion>)mySession.getAttribute("listaUbicaciones"); %>
           
           
        <h2>Empleados</h2>
        
        <div>
            <form action="/UsuariosTomcat/FiltoEmpleados">
                <select name="filtroEmpleados">
                    <% for(Ubicacion ubicacion: ubicaciones){%>
                    
                    <option value="<% ubicacion.getNombre(); %>">
                        <% ubicacion.getNombre(); %>
                    </option>
                    <%}%>
                </select>
                
            </form>
        </div>
                    
        <table>
            <caption>Lista de vehiculos</caption>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Ubicacion</th>
              
              <% if(isAdmin){%>
                <th>Salario</th>
                <th>Acciones</th>
              <%}%> 
                
              <th></th>
              
            </tr>
            
            <%
            
                
                
                for(Empleado empleado : empleados){ %>
                    <tr>
                        
                        <td><%=empleado.getId()%></td>
                        <td><%=empleado.getNombre()%></td>
                        <td><%=empleado.getUbicacion()%></td>
                        
                        <% if(isAdmin){%>
                            <td><%=empleado.getSalario()%></td>
                            <td>
                                <a href="http://localhost:8080/UsuariosTomcat/ModificaEmpleado?id=<%=empleado.getId()%>"><img src="img/refresh-button.png" alt="Basura para elminar empleado"/></a>
                                <a href="http://localhost:8080/UsuariosTomcat/EliminaEmpleado?id=<%=empleado.getId()%>"><img src="img/basurapeque.png" alt="Basura para elminar empleado"/></a>
                                                     
                            </td>
                       <%}%> 
                    </tr>
                 <%}%> 
        </table>
            
                    
                    
    </body>
</html>
