/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usuariostomcat.domain;

/**
 *
 * @author vgd_9
 */
public class Login {
    
    private Usuario usuario;
    private boolean logged;
    private final boolean power;

    public Login(Usuario usuario, boolean logged) {
        this.usuario = usuario;
        this.logged = logged;
        this.power = tienePoderes(usuario);
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the logged
     */
    public boolean isLogged() {
        return logged;
    }

    /**
     * @param logged the logged to set
     */
    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    private boolean tienePoderes(Usuario usuario) {
        
            return usuario.getRol().equalsIgnoreCase("admin");
    }

    public boolean isPower() {
        return power;
    } 
    
}
