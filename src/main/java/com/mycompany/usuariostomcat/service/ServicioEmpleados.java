/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.service;

import com.mycompany.usuariostomcat.domain.Empleado;
import com.mycompany.usuariostomcat.dao.DaoEmpleado;

import java.util.List;

/**
 *
 * @author vgd_9
 */
public class ServicioEmpleados {
     DaoEmpleado dao= new DaoEmpleado();
    
    

    public List<Empleado> getListaEmpleados() {
        return dao.getListEmpleados();
    }
    
    public Empleado getEmpleado(int id) {
        return dao.getEmpleado(id);
    }
}
