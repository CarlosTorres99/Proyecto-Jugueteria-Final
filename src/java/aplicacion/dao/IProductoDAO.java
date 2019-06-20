/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Producto;
import java.util.List;

/**
 *
 * @author Gaston
 */
public interface IProductoDAO {
    void agregar(Producto unProducto);
    void eliminar(Producto unProducto);
    void modificar(Producto unProducto);
    Producto consultar(Integer codProducto);
    List<Producto> obtenerListadoProductos();
}
