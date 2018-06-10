/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Usuario;

/**
 *
 * @author Fran
 */
public interface IUsuarioDao {
    
    public Usuario findByUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
    
}
