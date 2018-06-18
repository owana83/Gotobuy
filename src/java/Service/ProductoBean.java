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
import Entities.Ubicacion;
import Entities.UbicacionId;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Scope;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Fran
 */
@SessionScoped
@ManagedBean(name = "productoBean")
public class ProductoBean {

    private List<Producto> productos;
    private List<Producto> productosSubcategoria;
    private HashSet<String> categorias;
    private HashSet<String> subcategorias;
    private Producto productoSelect;
    String data = "";

    public ProductoBean() {
        this.productos = new ArrayList<Producto>();
        this.productosSubcategoria = new ArrayList<Producto>();
    }

    public List<Producto> getProductos() {
        IProductoDao productoDao = new ProductoHbmDao();
        this.productos = productoDao.obtenerProductos();
        return productos;
    }

    public List<Producto> getProductosSubcategoria() {

        return productosSubcategoria;
    }

    public HashSet<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(HashSet<String> categorias) {
        this.categorias = categorias;
    }

    public HashSet<String> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(HashSet<String> subcategorias) {
        this.subcategorias = subcategorias;
    }

    public Producto getProductoSelect() {
        return productoSelect;
    }

    public void setProductoSelect(Producto productoSelect) {
        this.productoSelect = productoSelect;
    }
    
    

    public String getData() {
        return data;
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
        this.data = subcategoria;
        return "productos";
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Se ha añadido el producto!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // ADMINISTRACION DE PRODUCTOS
    /**
     * Busca la lista productos de una seccion
     *
     * @param seccion
     * @return
     */
    public void productosSeccion(String seccion) {
        IProductoDao productoDao = new ProductoHbmDao();
        this.productosSubcategoria = new ArrayList<Producto>();
        this.categorias = new HashSet<String>();
        this.subcategorias = new HashSet<String>();
        
        this.productos = productoDao.obtenerProductos();
        //guardamos todos los productos de la seccion dada
        for (Producto p : productos) {
            if (p.getSeccion().equalsIgnoreCase(seccion)) {
                this.productosSubcategoria.add(p);
            }
        }
        //guardamos todas las categorias de la seccion dada
        for (Producto p : productosSubcategoria) {
            this.categorias.add(p.getCategoria());
        }
        //guardamos todas las subcategorias de la seccion dada
        for (Producto p : productosSubcategoria) {
            this.subcategorias.add(p.getSubcategoria());
        }
        this.data = seccion;
    }

    public void onRowEdit(RowEditEvent event) {
        Producto producto = new Producto();
        ProductoHbmDao productoDao = new ProductoHbmDao();
        producto = (Producto) event.getObject();
        productoDao.modificarProducto(producto);
        FacesMessage msg = new FacesMessage("Producto Edited", ((Producto) event.getObject()).getCodigo() + "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Producto) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Añade un producto nuevo a la tabla
     *
     * @param seccion
     */
    public void onAddNew(String seccion) {
        Producto producto = new Producto(seccion);
        ProductoHbmDao productoDao = new ProductoHbmDao();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(new UbicacionId("1", "1", "1"));
        producto.setUbicacion(ubicacion);
        productoDao.insertarProducto(producto);
        productosSubcategoria.add(producto);
        FacesMessage msg = new FacesMessage("Se ha añadido un nuevo producto", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void borrarProducto() {
        ProductoHbmDao productoDao = new ProductoHbmDao();
        productoDao.eliminarProducto(productoSelect);
        this.productosSubcategoria.remove(productoSelect);
        productoSelect = null;
    }

}
