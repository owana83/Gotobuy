/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Lista;
import java.util.List;

/**
 *
 * @author owana83
 */
public interface IListaDao {

    public List<Lista> obtenerListas();
    public Lista obtenerMiLista(int id);
    public long insertarLista(Lista lista) throws Exception;
    public void modificarLista(Lista lista) throws Exception;
    public void eliminarLista(Lista lista) throws Exception;

}
