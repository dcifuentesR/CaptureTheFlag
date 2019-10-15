package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Partida;
import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public interface CaptureTheFlagServices {


    ArrayList<Cuenta> getCuentas();

    void actualizarCuenta(Cuenta jugador, String nombre) throws CaptureTheFlagException;

    ArrayList<Partida> getPartidas(String nombre) throws CaptureTheFlagException;

    Partida getPartida(String nombre) throws CaptureTheFlagException;

    void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException;

    Cuenta getCuenta(Integer id) throws CaptureTheFlagException;

    Cuenta getCuenta(String nick) throws CaptureTheFlagException;
}
