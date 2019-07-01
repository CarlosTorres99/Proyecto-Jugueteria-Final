/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Categoria;
import java.util.List;

/**
 *
 * @author Gaston
 */
public interface ICategoriaDAO {
    void agregar(Categoria unaCategoria);
    void modificar(Categoria unaCategoria);
    void eliminar(Categoria unaCategoria);
    List<Categoria> obtenerCategoria();
}
