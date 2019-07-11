/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.formBean;

import aplicacion.bean.ModoPagoBean;
import aplicacion.modelo.dominio.Detalle;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.Modopago;
import aplicacion.modelo.dominio.Producto;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class DetalleFormBean implements Serializable{
    @ManagedProperty(value =  "#{modoPagoBean}")
    private ModoPagoBean modoPagoBean;
    private Detalle unDetalle;
    private List<Detalle> listadoDetalleCompra;
    private Integer cantidadProductos=0;
    private Double precioTotal;
    private List<Producto> listadoProdSeleccionados;
    private Producto unProducto;
    private Modopago modoPago;
    private Factura unaFactura;

    /**
     * Creates a new instance of DetalleFormBean
     */
    public DetalleFormBean() {
        unaFactura = new Factura();
        unDetalle = new Detalle();
        unProducto = new Producto();
        modoPago = new Modopago();
        listadoDetalleCompra = new ArrayList();
        listadoProdSeleccionados = new ArrayList();
    }

    public DetalleFormBean(Detalle unDetalle, List<Detalle> listadoDetalleCompra, Integer cantidadProductos, Double precioTotal, List<Producto> listadoProdSeleccionados, Producto unProducto) {
        this.unDetalle = unDetalle;
        this.listadoDetalleCompra = listadoDetalleCompra;
        this.cantidadProductos = cantidadProductos;
        this.precioTotal = precioTotal;
        this.listadoProdSeleccionados = listadoProdSeleccionados;
        this.unProducto = unProducto;
    }


    
    public void confirmarCompra(Producto unProducto){
        Detalle unDetalle = new Detalle();
        unDetalle.setProductos(unProducto);
        unDetalle.setCantidad(getCantidadProductos());
        precioTotal = (getCantidadProductos() * unProducto.getPrecio());
        unDetalle.setPrecioProdCant(precioTotal.toString());
        getListadoDetalleCompra().add(unDetalle);
    }
    
    public String comprar(){
        String resultado = null;
        resultado="compraProductos?faces-redirect=true";
        return resultado;
    }
    
    public void agregarCarrito(){
        try{
        listadoProdSeleccionados.add(unProducto);
        FacesMessage msg = new FacesMessage("Producto añadido al carrito");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fallo al seleccionar producto"));    
        }
        unProducto = new Producto();
    }
    
    public void establecerProducto(Producto otroProducto){
        unProducto = otroProducto;
    }
    
    public double Calculo(Producto unProducto){
        
        double total = 0;
        if(cantidadProductos==0){
            total = 1;
        }
        else{
        total = (unProducto.getPrecio() * cantidadProductos);
        }
        return total;
    }
    
    public List<Modopago> obtenerModosPagos(){
        return modoPagoBean.obtenerModoPago();
    }
    
    public String confirmarPago(){
        String resultado = null;
        getModoPago().setInteres(5.0);
        getUnaFactura().setModopago(getModoPago());
        getUnaFactura().setFecha(new Date());
        getUnaFactura().setUsuarios((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado"));
        resultado = "pagoCompra?faces-redirect=true";
        return resultado;
    }
    
    public double obtenerTotal(){
        double total=0;
        for(int i=0; i<listadoDetalleCompra.size();i++){
            total = total + listadoDetalleCompra.get(i).getProductos().getPrecio();
        }
        return total;
    }

    public Detalle getUnDetalle() {
        return unDetalle;
    }

    public void setUnDetalle(Detalle unDetalle) {
        this.unDetalle = unDetalle;
    }

    public List<Detalle> getListadoDetalleCompra() {
        return listadoDetalleCompra;
    }

    public void setListadoDetalleCompra(List<Detalle> listadoDetalleCompra) {
        this.listadoDetalleCompra = listadoDetalleCompra;
    }

    public Integer getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Producto> getListadoProdSeleccionados() {
        return listadoProdSeleccionados;
    }

    public void setListadoProdSeleccionados(List<Producto> listadoProdSeleccionados) {
        this.listadoProdSeleccionados = listadoProdSeleccionados;
    }

    public Producto getUnProducto() {
        return unProducto;
    }

    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    public Modopago getModoPago() {
        return modoPago;
    }

    public void setModoPago(Modopago modoPago) {
        this.modoPago = modoPago;
    }

    public ModoPagoBean getModoPagoBean() {
        return modoPagoBean;
    }

    public void setModoPagoBean(ModoPagoBean modoPagoBean) {
        this.modoPagoBean = modoPagoBean;
    }

    public Factura getUnaFactura() {
        return unaFactura;
    }

    public void setUnaFactura(Factura unaFactura) {
        this.unaFactura = unaFactura;
    }
    
}
