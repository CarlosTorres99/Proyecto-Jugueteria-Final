/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.LoginBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gaston
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private String nombreUs;
    private String passwUs;
    private Usuario usuarioEncontrado;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
        usuarioEncontrado = new Usuario();
    }

    public LoginFormBean(LoginBean loginBean, String nombreUs, String passwUs) {
        this.loginBean = loginBean;
        this.nombreUs = nombreUs;
        this.passwUs = passwUs;
    }
    
    public String validarUsuario(){
        String resultado = null;
        Usuario usuario = loginBean.ValidarUsuario(nombreUs, passwUs);
        if(usuario==null){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidadas", "Credenciales Invalidadas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Valido", "Usuario Valido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            if (usuario.getTipoUsuario().equals("cliente")){
                resultado="clientes?faces-redirect=true";
            }
            else{
              resultado="administrador?faces-redirect=true";  
            }
        }
        return resultado;
    }
    
    public String obtenerUsuario(){
        setUsuarioEncontrado((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado"));
        return getUsuarioEncontrado().getNombreUsuario();
    }

    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passwUs
     */
    public String getPasswUs() {
        return passwUs;
    }

    /**
     * @param passwUs the passwUs to set
     */
    public void setPasswUs(String passwUs) {
        this.passwUs = passwUs;
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Usuario getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public void setUsuarioEncontrado(Usuario usuarioEncontrado) {
        this.usuarioEncontrado = usuarioEncontrado;
    }

}
