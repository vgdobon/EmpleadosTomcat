/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.dao;

import com.mycompany.usuariostomcat.domain.Empleado;
import com.mycompany.usuariostomcat.domain.Ubicacion;
import com.mycompany.usuariostomcat.domain.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vgd_9
 */
public class DaoEmpleado {
  
    Connection conexion = null;
    String url = "jdbc:mysql://localhost:3306/enterprise?serverTimezone=" + TimeZone.getDefault().getID();
    String usuario = "root";
    String clave = "620312786";

    public DaoEmpleado() {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,clave);
            System.out.println("Conexión a la bbdd establecida.");
        }
        catch(SQLException ex)
        {
            System.out.println("Error la Base de Datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> getListEmpleados() {
        
        List<Empleado> empleados = new ArrayList<>();

        Statement statement;
        try {
            statement = conexion.createStatement();
            String sql = "SELECT * FROM empleados;";
            ResultSet resultSet = statement.executeQuery(sql);
            DaoUbicacion daoUbicacion=new DaoUbicacion();
            
            while(resultSet.next()){
                int id= resultSet.getInt("id");
                String nombre =resultSet.getString("nombre");
                int salario =resultSet.getInt("salario");
                String ubicacion = daoUbicacion.getUbicacion(resultSet.getInt("ubicacion")).getNombre();
                
                
                Empleado empleado = new Empleado(id,nombre,salario,ubicacion);
                empleados.add(empleado);
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

   
        return empleados;
    }

    public Empleado getEmpleado(int id) {
        
        Statement statement;
        DaoUbicacion daoUbicacion=new DaoUbicacion(); 
        Empleado empleado = null;
        
        try{
            statement = conexion.createStatement();
            String sql = "SELECT * FROM empleados WHERE  id=" + id + ";";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                
                int idEmpleado= resultSet.getInt("id");
                String nombre =resultSet.getString("nombre");
                int salario =resultSet.getInt("salario");
                String ubicacion = daoUbicacion.getUbicacion(resultSet.getInt("ubicacion")).getNombre();
                empleado = new Empleado(idEmpleado,nombre,salario,ubicacion);
            }
            
            statement.close();
        } catch (SQLException throwables) {
        }
        
        return empleado;
    }
    
}
