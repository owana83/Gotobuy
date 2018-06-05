/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuario;
import Persistencia.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Fran
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String sql = "FROM Usuario WHERE Email = '" + usuario.getEmail() + "'";

        try {
            sesion.beginTransaction();

            model = (Usuario) sesion.createQuery(sql).uniqueResult();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }

        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getPassword().equals(model.getPassword())) {
                model = null;
            }
        }
        return model;
    }
}
