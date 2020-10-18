/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.service;

import com.mycompany.usuariostomcat.domain.Usuario;
import com.mycompany.usuariostomcat.dao.DaoUsuario;

/**
 *
 * @author vgd_9
 */
public class ServicioUsuario {
    DaoUsuario dao= new DaoUsuario();
    
    

    public Usuario autenticarUsuario(String nombre, String pass) {
        return dao.cargarUsuario(nombre, pass);
    }
    
}
