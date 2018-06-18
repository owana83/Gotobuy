/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Lista;
import Persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author owana83
 */
public class ListaHbmDao implements IListaDao{

    private Session session;
    private Transaction tx;

    @Override
    public List<Lista> obtenerListas() {
        List<Lista> listaListas = null;

        try {
            iniciaOperacion();
            listaListas = session.createQuery("from Lista").list();
        } finally {
            session.close();
        }

        return listaListas;
    }

    public Lista obtenerMiLista(int id) throws HibernateException {
        Lista lista = null;
        try {
            iniciaOperacion();
            lista = (Lista) session.get(Lista.class, id);
        }catch(Exception e){
        /*finally {
            session.close();
        */

    }
        return lista;
    }
    @Override
    public long insertarLista(Lista producto) throws HibernateException {

        long id = 0;

        try {
            iniciaOperacion();
            id = (Long) session.save(producto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }

        return id;
    }

    @Override
    public void modificarLista(Lista producto) {

//        coger de la aplicacion del movil
    }

    @Override
    public void eliminarLista(Lista producto) {

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
