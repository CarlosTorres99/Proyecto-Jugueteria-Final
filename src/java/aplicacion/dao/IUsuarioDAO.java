/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.hibernate.mapeos.Usuarios;

/**
 *
 * @author Gaston
 */
public interface IUsuarioDAO {
    
    Usuarios ValidarUsuario (String nombreUsuario, String password);
    Usuarios obtenerUsuario (String nombreUsuario);
    
    void modificar(Usuarios unUsuario);
    
}
