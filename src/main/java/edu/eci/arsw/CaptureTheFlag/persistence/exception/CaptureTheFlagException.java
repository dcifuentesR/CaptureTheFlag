/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.CaptureTheFlag.persistence.exception;

/**
 *
 * @author USUARIO
 */
public class CaptureTheFlagException  extends Exception  {
    
    /**
     *
     */
    private static final long serialVersionUID = -153103053751423992L;
    public static String CorreoAlreadyExist = "Ya esta en uso este correo";
    public static String CorreoNotFound = "correo no encontrado";
    public static String LobbyAlreadyExist = "ya existe una sala con este nombre";
    public static String PlayerAlreadyExist = "Ya esta en uso este nick";
    public static String PlayerNotFoundException = "Este jugador no se encuentra registrado";
    public static String PartidaNotFound = "Partida no encontrada";
    public CaptureTheFlagException(String message) {
        super(message);
    }
    
}
