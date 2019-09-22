package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Poder;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerNotFoundException;

public interface CaptureTheFlagServices {

    Jugador getJugador(String nombre) throws PlayerNotFoundException;   
    void actualizarJugador(Jugador jugador,String nombre ) throws PlayerNotFoundException;
    void Atacar(Jugador jugador1, Jugador jugador2);
    void nuevoJugador(Jugador jugador)throws PlayerNotFoundException;
}
