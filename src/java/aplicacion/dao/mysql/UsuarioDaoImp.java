/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.hibernate.mapeos.Usuarios;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Gaston
 */
public class UsuarioDaoImp implements IUsuarioDAO{

    @Override
    public Usuarios ValidarUsuario(String nombreUsuario, String password) {
        Usuarios u = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("password", password));
        criteria.add(Restrictions.eq("estado", null));
        if(!criteria.list().isEmpty())
            u = (Usuarios)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public Usuarios obtenerUsuario(String nombreUsuario) {
        Usuarios u = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuarios.class);
        criteria.add(Restrictions.like("nombreUser", nombreUsuario));
        if(!criteria.list().isEmpty())
            u = (Usuarios)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public void modificar(Usuarios unUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
