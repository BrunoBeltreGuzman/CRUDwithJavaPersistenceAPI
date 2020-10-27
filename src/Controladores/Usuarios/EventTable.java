/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Usuarios;

import Modelos.Usuarios.CRUDUsuarios;
import Modelos.Usuarios.Usuarios.TableUsuarios;
import Modelos.Usuarios.EntityUsuario.Usuarios;
import Vistas.Ventana;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author diosl
 */
public class EventTable implements MouseListener {

    private final Ventana ventana;
    private final CRUDUsuarios crudUsuarios;
    private final Usuarios usuarios;
    private final TableUsuarios tableUsuarios;

    public EventTable(Ventana ventana, CRUDUsuarios crudUsuarios, Usuarios usuarios, TableUsuarios tableUsuarios) {
        this.ventana = ventana;
        this.crudUsuarios = crudUsuarios;
        this.usuarios = usuarios;
        this.tableUsuarios = tableUsuarios;

        ventana.getTable().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == ventana.getTable()) {
            this.eventTable();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void eventTable() {
        tableUsuarios.eventTable(ventana);
    }

}
