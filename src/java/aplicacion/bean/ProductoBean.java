/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.mysql.ProductoDaoImp;
import aplicacion.modelo.dominio.Producto;
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
public class ProductoBean implements Serializable{
    private IProductoDAO productoDao;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        productoDao = new ProductoDaoImp();
    }
    
    public void agregarProd(Producto prod){
        getProductoDao().agregar(prod);
    }
    public void elminarProd(Producto prod){
        getProductoDao().eliminar(prod);
    }
    public void modificarProd(Producto prod){
        getProductoDao().modificar(prod);
    }
    public Producto consultar(Integer codProd){
        return getProductoDao().consultar(codProd);
    }
    public List<Producto> obtenerListado(){
        return getProductoDao().obtenerListadoProductos();
    }

    public IProductoDAO getProductoDao() {
        return productoDao;
    }

    public void setProductoDao(IProductoDAO productoDao) {
        this.productoDao = productoDao;
    }
    
}
