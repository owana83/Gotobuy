/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.ProductoHbmDao;
import Entities.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Dao.IProductoDao;
import java.util.ArrayList;

/**
 *
 * @author Fran
 */
@SessionScoped
@ManagedBean(name = "productoBean")
public class ProductoBean {

    private List<Producto> productos;
    private List<Producto> productosSubcategoria;

    public List<Producto> getProductosSubcategoria() {
        return productosSubcategoria;
    }
    
    public ProductoBean() {
        this.productos = new ArrayList<Producto>();
        this.productosSubcategoria = new ArrayList<Producto>();
    }
    
    public List<Producto> getProductos() {
        IProductoDao productoDao = new ProductoHbmDao();
        this.productos = productoDao.obtenerProductos();
        return productos;
    }
    
    public String irAProductosSubcat(String subcategoria) {
        IProductoDao productoDao = new ProductoHbmDao();
        this.productosSubcategoria = new ArrayList<Producto>();
        this.productos = productoDao.obtenerProductos();
        for (Producto p : productos) {
            if (p.getSubcategoria().equalsIgnoreCase(subcategoria)) {
                this.productosSubcategoria.add(p);
            }
        }
        return "productos";
    }
    
}