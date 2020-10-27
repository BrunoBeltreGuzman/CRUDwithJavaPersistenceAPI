/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Usuarios.Usuarios;

import Modelos.Usuarios.EntityUsuario.Usuarios;
import Vistas.Ventana;

/**
 *
 * @author diosl
 */
public class DataUsuarios {

    public static void setDataUsuarios(Ventana ventana, Usuarios usuarios) {
        //data from ventana
        String nombre = ventana.getTextNombre().getText().trim();
        String correo = ventana.getTextCorreo().getText().trim();
        String user = ventana.getTextUser().getText().trim();
        String passWord = ventana.getTextPassWord().getText().trim();

        //set dato to user
        usuarios.setNombre(nombre);
        usuarios.setCorreo(correo);
        usuarios.setUser(user);
        usuarios.setPassword(passWord);
    }

    public static void setDataIdUsuarios(Ventana ventana, Usuarios usuarios) {
        //set only data id to user
        int id = Integer.parseInt(ventana.getTextId().getText());
        usuarios.setId(id);
    }

    public static String getTextBuscar(Ventana ventana) {
        //set data text
        String value = ventana.getTexBuscar().getText().trim();
        return value;
    }

    public static void deleteDataUsuarios(Usuarios usuarios) {
        usuarios.setId(null);
        usuarios.setNombre("");
        usuarios.setCorreo("");
        usuarios.setUser("");
        usuarios.setPassword("");
    }

    public static void deleteDataVetana(Ventana ventana) {
        ventana.getTextId().setText("");
        ventana.getTextNombre().setText("");
        ventana.getTextCorreo().setText("");
        ventana.getTextUser().setText("");
        ventana.getTextPassWord().setText("");
    }

    public static void deleteAllData(Ventana ventana, Usuarios usuarios) {
        deleteDataUsuarios(usuarios);
        deleteDataVetana(ventana);
    }

}
