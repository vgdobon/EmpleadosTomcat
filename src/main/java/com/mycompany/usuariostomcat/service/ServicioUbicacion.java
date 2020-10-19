/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.service;

import com.mycompany.usuariostomcat.domain.Ubicacion;
import com.mycompany.usuariostomcat.dao.DaoUbicacion;
import com.mycompany.usuariostomcat.domain.Empleado;
import java.util.List;

/**
 *
 * @author vgd_9
 */
public class ServicioUbicacion {
    DaoUbicacion dao = new DaoUbicacion();
    
    public List<Ubicacion> getListUbicacion(){
        return dao.getListUbicacion();
    }
    
    public Ubicacion getUbicacion(int id){
        return dao.getUbicacion(id);
    }
    
    public Ubicacion getUbicacion(String nombre){
        return dao.getUbicacion(nombre);
    }
    
    public void eliminarUbicacion(int id){
        
        dao.eliminarUbicacion(id);
    }
    
    public void insertarUbicacion(Ubicacion ubicacion){
        dao.insertarUbicacion(ubicacion);
    }
    
    public void modificarUbicacion(Ubicacion ubicacion){
        dao.modificarUbicacion(ubicacion);
    }
    
}
