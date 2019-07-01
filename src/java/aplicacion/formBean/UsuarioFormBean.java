/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.UsuarioBean;
import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gaston
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean implements Serializable{
    @ManagedProperty(value = "#{usuarioBean}")    
    private UsuarioBean usuarioBean;
    private Usuario us;
    private Integer dni;
    private Integer cod;
    private Random numero;
    private List<Usuario> listadoUsuarios;
    private Usuario unUsuario;
    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        us = new Usuario();
        numero = new Random();
        listadoUsuarios = new ArrayList();
        unUsuario = new Usuario();
    }

    public UsuarioFormBean(UsuarioBean usuarioBean, Usuario us, Integer dni, Integer cod, Random numero, List<Usuario> listadoUsuarios, Usuario unUsuario) {
        this.usuarioBean = usuarioBean;
        this.us = us;
        this.dni = dni;
        this.cod = cod;
        this.numero = numero;
        this.listadoUsuarios = listadoUsuarios;
        this.unUsuario = unUsuario;
    }
    
    public String agregarUs(){
        String resultado=null;
        try{
        cod = 1 + numero.nextInt(1000);
        us.setClientes(new Cliente(dni));
        us.setEstado(true);
        us.setCodigo(cod);
        us.setTipoUsuario("cliente");
        usuarioBean.agregarUs(us);
        resultado = "login?faces-redirect=true";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Creado"));
        }
        catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fallo al Crear Usuario"));
        }
        us = new Usuario();
        return resultado;
    }
    
    public List<Usuario> obtenerListaUsuariosActivos(){
        return listadoUsuarios = usuarioBean.obtenerListado();
    }
    
    public void eliminarUs(){
        usuarioBean.elminarUs(unUsuario);
        FacesMessage msg = new FacesMessage("Usuario Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unUsuario = new Usuario();
    }
    
    public void modificarUs(){
        usuarioBean.modificarUs(unUsuario);
        FacesMessage msg = new FacesMessage("Usuario Modificado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unUsuario = new Usuario();
    }
    
    public void establecerUsuario(Usuario otroUsuario){
        unUsuario = otroUsuario;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Random getNumero() {
        return numero;
    }

    public void setNumero(Random numero) {
        this.numero = numero;
    }

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
}
