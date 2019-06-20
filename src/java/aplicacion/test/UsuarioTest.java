/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.test;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Gaston
 */
public class UsuarioTest {
    public static void main(String[] gaston) {
        Usuario us = new Usuario();
        IUsuarioDAO usuarioDao = new UsuarioDaoImp();
        List<Usuario> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        
        for(int i=0;i<listado.size();i++){
            if(listado.get(i).getCodigo()==2){
                us = listado.get(i);
            }
        }
        us.setTipoUsuario("admin");
        usuarioDao.modificar(us);
        /*us.setApellidos("Choque");
        us.setCodigo(1321);
        us.setEstado(true);
        us.setNombreUsuario("KKKK");
        us.setClientes(new Cliente(223));
        //us.getClientes().setDni(234);
        IUsuarioDAO usuarioDao = new UsuarioDaoImp();
        usuarioDao.agregar(us);*/
    }
}
