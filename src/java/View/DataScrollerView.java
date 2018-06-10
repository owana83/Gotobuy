/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author owana83
 */
import Entities.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {
     
    private List<Producto> productos;
 
    public List<Producto> getProductos() {
        return productos;
    }
 /*
    public void setService(Producto producto) {
        this.producto = producto;
    }
*/
}