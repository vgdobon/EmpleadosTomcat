/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.service;

import com.mycompany.usuariostomcat.domain.Ubicacion;
import com.mycompany.usuariostomcat.dao.DaoUbicacion;
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
    
}
