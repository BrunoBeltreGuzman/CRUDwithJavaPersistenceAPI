/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Usuarios;

import Modelos.Usuarios.CRUDUsuarios;
import Modelos.Usuarios.Usuarios.BuscarUsuarios;
import Modelos.Usuarios.Usuarios.DataUsuarios;
import Modelos.Usuarios.Usuarios.TableUsuarios;
import Modelos.Usuarios.EntityUsuario.Usuarios;
import Vistas.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author diosl
 */
public class CtrlBuscar implements ActionListener, KeyListener {

    private final Ventana ventana;
    private final CRUDUsuarios crudUsuarios;
    private final Usuarios usuarios;
    private final TableUsuarios tableUsuarios;
    private final BuscarUsuarios buscarUsuarios;

    public CtrlBuscar(Ventana ventana, CRUDUsuarios crudUsuarios, Usuarios usuarios, TableUsuarios tableUsuarios, BuscarUsuarios buscarUsuarios) {
        this.ventana = ventana;
        this.crudUsuarios = crudUsuarios;
        this.usuarios = usuarios;
        this.tableUsuarios = tableUsuarios;
        this.buscarUsuarios = buscarUsuarios;

        this.ventana.getTexBuscar().addKeyListener(this);
        this.ventana.getBtnBruscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBtnBruscar()) {
            buscar();
        }
    }

    private void buscar() {
        String value = DataUsuarios.getTextBuscar(ventana);
        List<Usuarios> list = buscarUsuarios.buscarUsuarios(ventana, value);
        JTable table = ventana.getTable();
        tableUsuarios.setDataTable(table, list);
        tableUsuarios.setTextResultadoTable(ventana);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == ventana.getTexBuscar()) {
            buscar();
        }
    }

}
