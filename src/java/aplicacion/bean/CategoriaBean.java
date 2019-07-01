/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.dao.mysql.CategoriaDaoImp;
import aplicacion.modelo.dominio.Categoria;
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
public class CategoriaBean implements Serializable{
    private ICategoriaDAO categoriaDao;
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
        categoriaDao = new CategoriaDaoImp();
    }
    public void agregarCategoria(Categoria cat){
        categoriaDao.agregar(cat);
    }
    public void eliminarCategoria(Categoria cat){
        categoriaDao.eliminar(cat);
    }
    public void modificarCategoria(Categoria cat){
        categoriaDao.modificar(cat);
    }
    public List<Categoria> obtenerListado(){
        return categoriaDao.obtenerCategoria();
    }
}
