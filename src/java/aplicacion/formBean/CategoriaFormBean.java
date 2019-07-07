/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.CategoriaBean;
import aplicacion.modelo.dominio.Categoria;
import java.io.Serializable;
import java.util.List;
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
public class CategoriaFormBean implements Serializable{
    @ManagedProperty(value =  "#{categoriaBean}")
    private CategoriaBean categoriaBean;
    private Categoria cat;
    private Categoria unaCategoria;
    private int num=8;

    /**
     * Creates a new instance of CategoriaFormBean
     */
    public CategoriaFormBean() {
        cat = new Categoria();
        unaCategoria = new Categoria();
    }
    
    public void agregarCategoria(){
        try{
            cat.setIdcategoria(num);
            setNum(num+1);
            categoriaBean.agregarCategoria(cat);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoria Creada"));    
        }
        catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fallo al Crear Categoria"));    
        }
        cat = new Categoria();
    }
    
    public void eliminarCategoria(){
        categoriaBean.eliminarCategoria(unaCategoria);
        FacesMessage msg = new FacesMessage("Categoria Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unaCategoria = new Categoria();
    }
    
    public void modificarCategoria(){
        categoriaBean.modificarCategoria(unaCategoria);
        FacesMessage msg = new FacesMessage("Categoria Modificada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        unaCategoria = new Categoria();
    }
    
    public void establecerCategoria(Categoria otraCategoria){
        unaCategoria = otraCategoria;
    }
    
    public List<Categoria> obtenerCategorias(){
        return getCategoriaBean().obtenerListado();
    }

    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public Categoria getUnaCategoria() {
        return unaCategoria;
    }

    public void setUnaCategoria(Categoria unaCategoria) {
        this.unaCategoria = unaCategoria;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
    
}
