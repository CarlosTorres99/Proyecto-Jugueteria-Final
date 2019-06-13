/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IProductoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Producto;
import org.hibernate.Session;

/**
 *
 * @author Gaston
 */
public class ProductoDaoImp implements IProductoDAO{

    @Override
    public void agregar(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Producto unProducto) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Producto consultar(Integer codProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
