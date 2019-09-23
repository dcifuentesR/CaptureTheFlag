/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.CaptureTheFlag.persistence;

/**
 *
 * @author USUARIO
 */
public class CorreoNotFound extends Exception {

    public CorreoNotFound() {
        super("No se encontro el correo");
    }

}
