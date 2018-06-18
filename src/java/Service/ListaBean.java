/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.IListaDao;
import Dao.ListaHbmDao;
import Entities.Lista;
import Entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fran
 */
@ManagedBean
@SessionScoped
public class ListaBean {

    private List<Lista> listas;
    private Lista lista;

    public ListaBean() {
        this.listas = new ArrayList<>();
    }

    public List<Lista> getListas() {
        IListaDao listaDao = new ListaHbmDao();
        this.listas = listaDao.obtenerListas();
        return listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }
/*
    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
*/

    public Lista getLista(int id) {
        IListaDao listaDao = new ListaHbmDao();
        this.lista = listaDao.obtenerMiLista(id);
        return lista;
    }

    
    
    public void setLista(Lista lista) {
        this.lista = lista;
    }
    
    /*
    
    public String add(Producto producto) {
        this.listas.

        return "cart?faces-redirect=true";
    }
*/
    public String delete(Producto producto) {
        this.lista.getProductos().remove(producto);

        return "cart?faces-redirect=true";
    }

    public int totalProductos() {
        return this.lista.getProductos().size();
    }

    public double precioTotal() {
        double total = 0;
        for (Producto p : this.lista.getProductos()) {
            total += p.getPrecio();
        }
        return total;
    }
    /*
    DELETEME
    
    private int exists(Producto producto) {
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getProducto().getId() == producto.getId()) {
                return i;
            }
        }
        return -1;
    }
     */
}
