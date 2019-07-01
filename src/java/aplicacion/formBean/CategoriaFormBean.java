/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.CategoriaBean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gaston
 */
@ManagedBean
@RequestScoped
public class CategoriaFormBean implements Serializable{
    @ManagedProperty(value =  "#(categoriaBean)")
    private CategoriaBean categoriaBean;

    /**
     * Creates a new instance of CategoriaFormBean
     */
    public CategoriaFormBean() {
    }
    
}
