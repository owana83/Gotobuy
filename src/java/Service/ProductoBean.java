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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
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
    Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    private List<Producto> productos;
    private List<Producto> productosSubcategoria;
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
    public List<Producto> productosSeccion(String seccion) {
        IProductoDao productoDao = new ProductoHbmDao();
        this.productosSubcategoria = new ArrayList<Producto>();
        this.productos = productoDao.obtenerProductos();
        for (Producto p : productos) {
            if (p.getSeccion().equalsIgnoreCase(seccion)) {
                this.productosSubcategoria.add(p);
            }
        }
        this.data = seccion;
        return productosSubcategoria;
    }

    public void onRowEdit(RowEditEvent event) {
        /*Producto productoRecuperado = (Producto) event.getObject();
        ProductoHbmDao productoDao = new ProductoHbmDao();
        productoDao.modificarProducto(producto);
        producto = new Producto();*/
        ProductoHbmDao productoDao = new ProductoHbmDao();
        producto = (Producto) event.getObject();
        productoDao.modificarProducto(producto);
        FacesMessage msg = new FacesMessage("Producto Edited", ((Producto) event.getObject()).getCodigo()+"");
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
        Producto productoAdd = new Producto();
        productoAdd.setSeccion(seccion);
        ProductoHbmDao productoDao = new ProductoHbmDao();
        productoDao.insertarProducto(productoAdd);
        FacesMessage msg = new FacesMessage("Se ha añadido un nuevo producto", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
