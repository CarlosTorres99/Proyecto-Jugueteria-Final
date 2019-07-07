/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.test;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.dao.IProductoDAO;
import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.CategoriaDaoImp;
import aplicacion.dao.mysql.ProductoDaoImp;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Producto;
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
        /*int num = 1;
        Categoria prod = new Categoria();
        IProductoDAO productoDao = new ProductoDaoImp();
        List<Producto> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        
        for(int i=0;i<listado.size();i++){
            System.out.println(+listado.get(i).getPrecio());
        }
        //categoriaDao.eliminar(cat);
        /*us.setApellidos("Choque");
        us.setCodigo(1321);
        us.setEstado(true);
        us.setNombreUsuario("KKKK");
        us.setClientes(new Cliente(223));
        //us.getClientes().setDni(234);
        IUsuarioDAO usuarioDao = new UsuarioDaoImp();
        usuarioDao.agregar(us);*/
        List<Producto> listado = new ArrayList();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        listado = criteria.list();
        session.getTransaction().commit();
        session.close();
        
        IProductoDAO productoDao = new ProductoDaoImp();
        Producto prod= new Producto();
        prod = listado.get(1);
        prod.setEstado(Boolean.TRUE);
        productoDao.modificar(prod);
        
        /*prod.setCategorias(listado.get(0));
        prod.setDescripcion("prueba");
        IProductoDAO productoDao = new ProductoDaoImp();
        productoDao.agregar(prod);*/
    }
}
