/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gaston
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    
    private Usuario usuario;
    private IUsuarioDAO usuarioDao; 

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        usuarioDao = new UsuarioDaoImp();
    }
    
    public Usuario ValidarUsuario(String nombreUs, String passwUs){
        getUsuarioDao().ValidarUsuario(nombreUs, passwUs);
        return getUsuario();
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
     * @return the usuarioDao
     */
    public IUsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    public void setUsuarioDao(IUsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
}
