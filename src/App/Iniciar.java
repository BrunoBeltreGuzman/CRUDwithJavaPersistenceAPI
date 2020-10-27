/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controladores.Usuarios.CtrlBuscar;
import Controladores.Usuarios.CtrlUsuarios;
import Controladores.Usuarios.EventTable;
import Modelos.Usuarios.CRUDUsuarios;
import Modelos.Usuarios.Usuarios.BuscarUsuarios;
import Modelos.Usuarios.Usuarios.TableUsuarios;
import Modelos.Usuarios.EntityUsuario.Usuarios;
import Modelos.Usuarios.EntityUsuario.UsuariosJpa;
import Vistas.Ventana;

/**
 *
 * @author diosl
 */
public class Iniciar {

    public static void iniciar() {
        //Vistas
        Ventana ventana = new Ventana();

        //Modelos
        Usuarios usuarios = new Usuarios();
        TableUsuarios tableUsuarios = new TableUsuarios();
        UsuariosJpa usuariosJpa = new UsuariosJpa();
        CRUDUsuarios crudUsuarios = new CRUDUsuarios(usuariosJpa);
        BuscarUsuarios buscarUsuarios = new BuscarUsuarios(usuariosJpa);

        //Controladores
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios(ventana, crudUsuarios, usuarios, tableUsuarios);
        EventTable eventTable = new EventTable(ventana, crudUsuarios, usuarios, tableUsuarios);
        CtrlBuscar ctrlBuscar = new CtrlBuscar(ventana, crudUsuarios, usuarios, tableUsuarios, buscarUsuarios);

        //Iniciar
        ventana.setVisible(true);
    }
}
