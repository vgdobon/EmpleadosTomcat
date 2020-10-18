/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.dao;

import com.mycompany.usuariostomcat.domain.Empleado;
import com.mycompany.usuariostomcat.domain.Ubicacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vgd_9
 */

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
public class DaoUbicacion {
  
    Connection conexion = null;
    String url = "jdbc:mysql://localhost:3306/enterprise?serverTimezone=" + TimeZone.getDefault().getID();
    String usuario = "root";
    String clave = "620312786";

    public DaoUbicacion() {

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
            Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Ubicacion> getListUbicacion() {
        
        List<Ubicacion> ubicaciones = new ArrayList<>();

        Statement statement;
        try {
            statement = conexion.createStatement();
            String sql = "SELECT * FROM ubicacion;";
            ResultSet resultSet = statement.executeQuery(sql);
  
            
            while(resultSet.next()){
                int id= resultSet.getInt("id");
                String nombre =resultSet.getString("nombre");
                
                Ubicacion ubicacion = new Ubicacion(id,nombre);
                ubicaciones.add(ubicacion);
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

   
        return ubicaciones;
    }
    
    public Ubicacion getUbicacion(int idUbicacion) {
        
        Ubicacion ubicacion = null;
        Statement statement;
        try {
            statement = conexion.createStatement();
            String sql = "SELECT * FROM ubicacion WHERE id='" + idUbicacion + "';";;
            ResultSet resultSet = statement.executeQuery(sql);
  
            
            if(resultSet.next()){
                int id= resultSet.getInt("id");
                String nombre =resultSet.getString("nombre");               
                ubicacion = new Ubicacion(id,nombre);
                
            }
            statement.close();
        } catch (SQLException throwables) {
        }
        

   
        return ubicacion;
    }

}


