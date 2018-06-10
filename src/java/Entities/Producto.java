package Entities;
// Generated 25-may-2018 20:04:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int codigo;
     private Ubicacion ubicacion;
     private String seccion;
     private String categoria;
     private String subcategoria;
     private String marca;
     private String nombre;
     private Byte precio;
     private String imagen;
     private Set<Lista> listas = new HashSet<Lista>(0);

    public Producto() {
    }

	
    public Producto(int codigo, Ubicacion ubicacion) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
    }
    public Producto(int codigo, Ubicacion ubicacion, String seccion, String categoria, String subcategoria, String marca, String nombre, Byte precio, String imagen, Set<Lista> listas) {
       this.codigo = codigo;
       this.ubicacion = ubicacion;
       this.seccion = seccion;
       this.categoria = categoria;
       this.subcategoria = subcategoria;
       this.marca = marca;
       this.nombre = nombre;
       this.precio = precio;
       this.imagen = imagen;
       this.listas = listas;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getSubcategoria() {
        return this.subcategoria;
    }
    
    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Byte getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Byte precio) {
        this.precio = precio;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Set<Lista> getListas() {
        return this.listas;
    }
    
    public void setListas(Set<Lista> listas) {
        this.listas = listas;
    }




}

