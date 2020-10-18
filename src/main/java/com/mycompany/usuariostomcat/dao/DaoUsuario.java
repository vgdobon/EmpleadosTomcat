/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.dao;

import com.mycompany.usuariostomcat.domain.Usuario;
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
public class DaoUsuario {
  
    Connection conexion = null;
    String url = "jdbc:mysql://localhost:3306/enterprise?serverTimezone=" + TimeZone.getDefault().getID();
    String usuario = "root";
    String clave = "620312786";

    public DaoUsuario(){

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
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Usuario> cargarUsuarios() {
       List<Usuario> usuarios = new ArrayList<>();

        Statement statement;
        try {
            statement = conexion.createStatement();
            String sql = "SELECT * FROM usuarios;";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                String nombreBBDD =resultSet.getString("nombre");
                String passBBDD =resultSet.getString("password");
                String rol= resultSet.getString("rol");
                Usuario usuarioLista = new Usuario(nombreBBDD,passBBDD,rol);
                usuarios.add(usuarioLista);
            }
            statement.close();
        } catch (SQLException throwables) {
        }

        return usuarios;
    }
    
    public Usuario cargarUsuario(String nombre,String pass) {

        Usuario usuarioUnico = null;
        Statement statement;
        
        try{
            statement = conexion.createStatement();
            String sql = "SELECT * FROM usuarios WHERE  nombre='" + nombre + "' " +
                                                "AND password='" + pass + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                String nombreBBDD =resultSet.getString("nombre");
                String passBBDD =resultSet.getString("password");
                String rol= resultSet.getString("rol");
                usuarioUnico = new Usuario(nombreBBDD,passBBDD,rol);
            }
            
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return usuarioUnico;
    }
}
