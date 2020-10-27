/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores.Usuarios;

import Modelos.Usuarios.CRUDUsuarios;
import Modelos.Usuarios.Usuarios.DataUsuarios;
import Modelos.Usuarios.Usuarios.TableUsuarios;
import Modelos.Usuarios.EntityUsuario.Usuarios;
import Vistas.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author diosl
 */
public class CtrlUsuarios implements ActionListener {

    private final Ventana ventana;
    private final CRUDUsuarios crudUsuarios;
    private final Usuarios usuarios;
    private final TableUsuarios tableUsuarios;

    public CtrlUsuarios(Ventana ventana, CRUDUsuarios crudUsuarios, Usuarios usuarios, TableUsuarios tableUsuarios) {
        this.ventana = ventana;
        this.crudUsuarios = crudUsuarios;
        this.usuarios = usuarios;
        this.tableUsuarios = tableUsuarios;

        setDataTable();

        this.ventana.getBtnRegistrar().addActionListener(this);
        this.ventana.getBtnModificar().addActionListener(this);
        this.ventana.getBtnEliminar().addActionListener(this);
        this.ventana.getBtnLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBtnRegistrar()) {
            registrarUsuario();
        }

        if (e.getSource() == ventana.getBtnModificar()) {
            actualizarUsuario();
        }

        if (e.getSource() == ventana.getBtnEliminar()) {
            eliminarUsuario();
        }

        if (e.getSource() == ventana.getBtnLimpiar()) {
            limpiar();
        }
    }

    private void setDataTable() {
        JTable table = ventana.getTable();
        List<Usuarios> list = crudUsuarios.listarUsuarios();
        this.tableUsuarios.setDataTable(table, list);
        tableUsuarios.setTextResultadoTable(ventana);
    }

    private void registrarUsuario() {
        DataUsuarios.setDataUsuarios(ventana, usuarios);
        boolean boo = crudUsuarios.registar(usuarios);
        if (boo) {
            JOptionPane.showMessageDialog(null, "Datos registrados satisfactoriamente");
            DataUsuarios.deleteDataUsuarios(usuarios);
            DataUsuarios.deleteDataVetana(ventana);
            setDataTable();
        }
    }

    private void actualizarUsuario() {
        DataUsuarios.setDataUsuarios(ventana, usuarios);
        DataUsuarios.setDataIdUsuarios(ventana, usuarios);
        boolean boo = crudUsuarios.actualizar(usuarios);
        if (boo) {
            JOptionPane.showMessageDialog(null, "Datos actualizados satisfactoriamente");
            DataUsuarios.deleteDataUsuarios(usuarios);
            DataUsuarios.deleteDataVetana(ventana);
            setDataTable();
        }
    }

    private void eliminarUsuario() {
        DataUsuarios.setDataIdUsuarios(ventana, usuarios);
        boolean boo = crudUsuarios.eliminar(usuarios);
        if (boo) {
            JOptionPane.showMessageDialog(null, "Datos eliminados satisfactoriamente");
            DataUsuarios.deleteDataUsuarios(usuarios);
            DataUsuarios.deleteDataVetana(ventana);
            setDataTable();
        }
    }

    private void limpiar() {
        DataUsuarios.deleteAllData(this.ventana, this.usuarios);
    }

}
