/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IModoPagoDAO;
import aplicacion.dao.mysql.ModopagoDaoImp;
import aplicacion.modelo.dominio.Modopago;
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
public class ModoPagoBean implements Serializable{
    private IModoPagoDAO modoPagoDao;

    /**
     * Creates a new instance of ModoPagoBean
     */
    public ModoPagoBean() {
        modoPagoDao = new ModopagoDaoImp();
    }
    
    public List<Modopago> obtenerModoPago(){
        return getModoPagoDao().listadoModoPago();
    }

    public IModoPagoDAO getModoPagoDao() {
        return modoPagoDao;
    }

    public void setModoPagoDao(IModoPagoDAO modoPagoDao) {
        this.modoPagoDao = modoPagoDao;
    }
    
}
