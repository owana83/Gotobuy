/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Producto;
import Persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fran
 */
public class ProductoHbmDao implements IProductoDao {

    private Session session;
    private Transaction tx;

    @Override
    public List<Producto> obtenerProductos() {
        List<Producto> listaProductos = null;

        try {
            iniciaOperacion();
            listaProductos = session.createQuery("from Producto").list();
        } finally {
            session.close();
        }

        return listaProductos;
    }
/*
    @Override
    public List<Producto> mostrarProductosSeccion(String seccion) {
        List<Producto> listaProductos = null;
        
        try {
            iniciaOperacion();
            listaProductos = session.createQuery("from Producto ").list();
        } finally {
            session.close();
        }

        return listaProductos;
    }
*/
    public Producto obtenerProducto(int codigo) throws HibernateException {
        Producto producto = null;
        try {
            iniciaOperacion();
            producto = (Producto) session.get(Producto.class, codigo);
        } finally {
            session.close();
        }

        return producto;
    }

    @Override
    public void insertarProducto(Producto producto) {

//        coger de la aplicacion del movil
    }

    @Override
    public void modificarProducto(Producto producto) {

//        coger de la aplicacion del movil
    }

    @Override
    public void eliminarProducto(Producto producto) {

//        coger de la aplicacion del movil
    }

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

}
