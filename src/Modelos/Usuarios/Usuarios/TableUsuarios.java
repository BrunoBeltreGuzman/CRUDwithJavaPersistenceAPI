/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Usuarios.Usuarios;

import Modelos.Usuarios.EntityUsuario.Usuarios;
import Vistas.Colores;
import Vistas.Ventana;
import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diosl
 */
public class TableUsuarios {

    private DefaultTableModel modelo;

    public void setModelTable(JTable table) {
        String columnas[] = {"Id", "Nombre", "Correo", "User", "PassWord"};
        modelo = new DefaultTableModel(columnas, 0);

        Colores colores = new Colores();
        table.getTableHeader().setFont(new java.awt.Font("Arial", 0, 16));
        table.getTableHeader().setBackground(colores.getColorPrymary());
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(18);
        table.setBorder(null);
        table.setFont(new java.awt.Font("Arial", 0, 16));
        table.setForeground(Color.WHITE);
        table.setBackground(colores.getGris1());
        table.setRowHeight(18);
        table.setSelectionBackground(colores.getColorPrymary());
        table.setSelectionForeground(Color.WHITE);
        table.setOpaque(true);

        /*int[] ancho = {5, 100, 100, 100, 100};
        for (int x = 0; x < 5; x++) {
            table.getColumnModel().getColumn(x).setPreferredWidth(ancho[x]);
        }*/
    }

    public void setDataTable(JTable table, List<Usuarios> list) {
        try {
            setModelTable(table);
            Object object[] = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                object[0] = list.get(i).getId();
                object[1] = list.get(i).getNombre();
                object[2] = list.get(i).getCorreo();
                object[3] = list.get(i).getUser();
                object[4] = list.get(i).getPassword();
                modelo.addRow(object);
            }
            table.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void setTextResultadoTable(Ventana ventana) {
        int count = ventana.getTable().getRowCount();
        ventana.getTexResultado().setText(count + " resultados");
    }

    public void eventTable(Ventana ventana) {
        int id = ventana.getTable().getSelectedRow();
        ventana.getTextId().setText(ventana.getTable().getValueAt(id, 0).toString().trim());
        ventana.getTextNombre().setText(ventana.getTable().getValueAt(id, 1).toString().trim());
        ventana.getTextCorreo().setText(ventana.getTable().getValueAt(id, 2).toString().trim());
        ventana.getTextUser().setText(ventana.getTable().getValueAt(id, 3).toString().trim());
        ventana.getTextPassWord().setText(ventana.getTable().getValueAt(id, 4).toString().trim());
    }

}
