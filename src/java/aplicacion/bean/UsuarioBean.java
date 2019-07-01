/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author Gaston
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private IUsuarioDAO usuarioDao; 
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuarioDao=  new UsuarioDaoImp();
    }
    
    public void agregarUs(Usuario us){
        usuarioDao.agregar(us);
    }
    public void elminarUs(Usuario us){
        usuarioDao.eliminar(us);
    }
    public void modificarUs(Usuario us){
        usuarioDao.modificar(us);
    }
    public void consultar(String nombreUs){
        usuarioDao.consultar(nombreUs);
    }
    public List<Usuario> obtenerListado(){
        return usuarioDao.obtenerListaUsuariosActivos();
    }
}
