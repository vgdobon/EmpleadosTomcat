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
    
    public Ubicacion getUbicacion(String nombreUbicacion) {
        
        Ubicacion ubicacion = null;
        Statement statement;
        try {
            statement = conexion.createStatement();
            String sql = "SELECT * FROM ubicacion WHERE nombre='" + nombreUbicacion + "';";;
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

    
    public void insertarUbicacion(Ubicacion ubicacion) {
        Statement statement;
        try {
            statement = conexion.createStatement();
            
            String sql ="INSERT INTO ubicacion(id,nombre)VALUES('"+ubicacion.getId()+"','"+ubicacion.getNombre()+"');";
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            System.out.println("Conexion cerrada");
        }
    }
     
     
     public void modificarUbicacion(Ubicacion ubicacion)  {
        Statement s;
        try {
            s = this.conexion.createStatement();           
            String sql = "UPDATE ubicacion SET "
                    + "id= '" + ubicacion.getId()+"', "
                    + "nombre='"+ubicacion.getNombre() + "', " +
                    "WHERE id=" + ubicacion.getId() + ";";
                
            s.executeUpdate(sql);
                  
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            System.out.println("Conexion cerrada");
        }
    }

    public String eliminarUbicacion(int id) {
        Statement s;
        try {
            s = this.conexion.createStatement();
            String sql = "DELETE FROM ubicacion WHERE id=" + id + ";";
            int rowModified = s.executeUpdate(sql);

            if(rowModified==1){

                return "Se ha eliminado correctamente el registro de la bbdd";

            }else{

                return "No se ha eliminado el registro de la bbdd";

            }

        } catch (SQLException throwables) {
            
            throwables.printStackTrace();
           
        } finally {
            
            System.out.println("Conexion cerrada");
        }

        return "Error";

    }

    
}


