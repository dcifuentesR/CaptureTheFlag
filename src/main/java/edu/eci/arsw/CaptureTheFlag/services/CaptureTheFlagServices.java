package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Sala;
import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.LobbyNotFoundException;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerAlreadyExist;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerNotFoundException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public interface CaptureTheFlagServices {

    Jugador getJugador(String nombre) throws PlayerNotFoundException;

    ArrayList<Jugador> getJugadores();

    void actualizarJugador(Jugador jugador, String nombre) throws PlayerNotFoundException;

    void Atacar(Jugador jugador1, Jugador jugador2);

    void nuevoJugador(Jugador jugador) throws PlayerAlreadyExist;

    Sala getSala(String nombre) throws LobbyNotFoundException;

    void agregarJugadorSala(Jugador jugador, String sala) throws LobbyNotFoundException;

    void agregarCuenta(Cuenta cuenta) throws CorreoAlredyExist;

    Cuenta getCuenta(String correo) throws CorreoNotFound;
}
