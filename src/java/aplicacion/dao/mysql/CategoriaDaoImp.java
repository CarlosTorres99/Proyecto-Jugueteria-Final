/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Gaston
 */
public class CategoriaDaoImp implements ICategoriaDAO{

    @Override
    public void agregar(Categoria unaCategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Categoria unaCategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Categoria unaCategoria) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Categoria> obtenerCategoria() {
        List<Categoria> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Categoria.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado;
    }
    
}
