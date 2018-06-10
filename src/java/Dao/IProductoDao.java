/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Producto;
import java.util.List;

/**
 *
 * @author Fran
 */
public interface IProductoDao {
    
    public List<Producto> obtenerProductos();
//    public List<Producto> mostrarProductosSeccion();
    public void insertarProducto(Producto producto) throws Exception;
    public void modificarProducto(Producto producto) throws Exception;
    public void eliminarProducto(Producto producto) throws Exception;
        
    
}
