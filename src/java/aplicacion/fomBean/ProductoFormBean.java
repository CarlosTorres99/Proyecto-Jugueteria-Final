/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.fomBean;

import aplicacion.bean.ProductoBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;
import java.util.List;
import java.util.Random;
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
public class ProductoFormBean {
    @ManagedProperty(value =  "#(productoBean)")
    private ProductoBean productoBean;
    private Producto prod;
    private Integer cod;
    private Random numero;
    private List<Categoria> categorias;
    private List<Producto>listadoProductos;

    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
        prod = new Producto();
        categorias.add(new Categoria(1,"Peluches",null,null));
        categorias.add(new Categoria(1,"Muñecos",null,null));
        categorias.add(new Categoria(1,"Juegos de Mesa",null,null));
    }
    
    
    public void agregarProducto(){
        try{
        cod = 1 + numero.nextInt(1000);
        prod.setCodProducto(cod);
        
        productoBean.agregarProd(prod);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Creado"));    
        }
        catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fallo al Crear Usuario"));    
        }    
    }
    public List obtenerListaProductos(){
        return listadoProductos = productoBean.obtenerListado();
    }

    public ProductoBean getProductoBean() {
        return productoBean;
    }

    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
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
}
