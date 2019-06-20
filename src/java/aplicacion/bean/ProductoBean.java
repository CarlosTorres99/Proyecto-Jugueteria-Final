/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.mysql.ProductoDaoImp;
import aplicacion.modelo.dominio.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gaston
 */
@ManagedBean
@RequestScoped
public class ProductoBean {
    private IProductoDAO productoDao;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        productoDao = new ProductoDaoImp();
    }
    
    public void agregarProd(Producto prod){
        productoDao.agregar(prod);
    }
    public void elminarProd(Producto prod){
        productoDao.eliminar(prod);
    }
    public void modificarUs(Producto prod){
        productoDao.modificar(prod);
    }
    public void consultar(Integer codProd){
        productoDao.consultar(codProd);
    }
    public List<Producto> obtenerListado(){
        return productoDao.obtenerListadoProductos();
    }

    public IProductoDAO getProductoDao() {
        return productoDao;
    }

    public void setProductoDao(IProductoDAO productoDao) {
        this.productoDao = productoDao;
    }
    
}
