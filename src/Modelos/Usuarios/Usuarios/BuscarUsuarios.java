/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Usuarios.Usuarios;

import Modelos.Usuarios.EntityUsuario.Usuarios;
import Modelos.Usuarios.EntityUsuario.UsuariosJpa;
import Vistas.Ventana;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author diosl
 */
public class BuscarUsuarios {

    private final UsuariosJpa usuariosJpa;

    public BuscarUsuarios(UsuariosJpa usuariosJpa) {
        this.usuariosJpa = usuariosJpa;
    }

    public String getWhere(Ventana ventana) {
        String where = null;

        //where nombre
        if (ventana.getCbBuscar().getSelectedIndex() == 1) {
            where = "where u.nombre Like :value";
        }

        //where correo
        if (ventana.getCbBuscar().getSelectedIndex() == 2) {
            where = "where u.correo Like :value";
        }

        //where user
        if (ventana.getCbBuscar().getSelectedIndex() == 3) {
            where = "where u.user Like :value";
        }

        //where password
        if (ventana.getCbBuscar().getSelectedIndex() == 4) {
            where = "where u.password Like :value";
        }

        //default
        if (where == null) {
            where = "";
        }
        return where;
    }

    public List<Usuarios> buscarUsuarios(Ventana ventana, String value) {
        List<Usuarios> list = null;
        try {
            EntityManager entityManager = usuariosJpa.getEntityManager();
            Query query = entityManager.createQuery("select u from Usuarios u " + getWhere(ventana));
            query.setParameter("value", "%" + value + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

}
