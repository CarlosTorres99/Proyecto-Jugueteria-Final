/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IModoPagoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Modopago;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Gaston
 */
public class ModopagoDaoImp implements IModoPagoDAO{

    @Override
    public List<Modopago> listadoModoPago() {
        List<Modopago> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Modopago.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado;
    }
    
}
