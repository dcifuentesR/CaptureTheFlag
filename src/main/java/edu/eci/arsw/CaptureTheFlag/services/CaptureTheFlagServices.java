package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Partida;
import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Jugar;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;

import java.sql.Time;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public interface CaptureTheFlagServices {

    ArrayList<Cuenta> getCuentas();

    void actualizarCuenta(Cuenta jugador, String nombre) throws CaptureTheFlagException;
    
    void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException;

    Cuenta getCuenta(Long id) throws CaptureTheFlagException;

    Cuenta getCuenta(String nick) throws CaptureTheFlagException;

    ArrayList<Partida> getPartidas() throws CaptureTheFlagException;

    Partida getPartida(Integer id) throws CaptureTheFlagException;
    
    ArrayList<Jugar> getPartidasUsuario(String nick) throws CaptureTheFlagException;

    void registrarPartida(Partida partida);

    void registrarPartidaUsuario(Jugar jugar) throws CaptureTheFlagException;
    


}
