/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Usuarios;

import Modelos.Usuarios.EntityUsuario.Usuarios;
import Modelos.Usuarios.EntityUsuario.UsuariosJpa;
import Modelos.Usuarios.EntityUsuario.exceptions.NonexistentEntityException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author diosl
 */
public class CRUDUsuarios {

    private final UsuariosJpa usuariosJpa;

    public CRUDUsuarios(UsuariosJpa usuariosJpa) {
        this.usuariosJpa = usuariosJpa;
    }

    public boolean registar(Usuarios usuarios) {
        try {
            usuariosJpa.create(usuarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Usuarios usuarios) {
        try {
            usuariosJpa.edit(usuarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean eliminar(Usuarios usuarios) {
        try {
            int id = usuarios.getId();
            usuariosJpa.destroy(id);
            return true;
        } catch (NonexistentEntityException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public List<Usuarios> listarUsuarios() {
        List<Usuarios> list = null;
        try {
            list = usuariosJpa.findUsuariosEntities();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
