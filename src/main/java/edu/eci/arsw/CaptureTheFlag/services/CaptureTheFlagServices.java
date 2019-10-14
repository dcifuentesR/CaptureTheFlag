package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Sala;
import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public interface CaptureTheFlagServices {

    Jugador getJugador(String nombre) throws CaptureTheFlagException;

    ArrayList<Jugador> getJugadores();

    void actualizarJugador(Jugador jugador, String nombre) throws CaptureTheFlagException;

    void Atacar(Jugador jugador1, Jugador jugador2);

    void nuevoJugador(Jugador jugador) throws CaptureTheFlagException;

    Sala getSala(String nombre) throws CaptureTheFlagException;

    void agregarJugadorSala(Jugador jugador, String sala) throws CaptureTheFlagException;

    void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException;

    Cuenta getCuenta(Integer id) throws CaptureTheFlagException;

	Cuenta getCuenta(String correo) throws CaptureTheFlagException;
}
