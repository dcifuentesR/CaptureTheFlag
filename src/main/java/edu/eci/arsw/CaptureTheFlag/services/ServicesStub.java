/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Poder;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author USUARIO
 */
public class ServicesStub implements CaptureTheFlagServices {

    HashMap<String, Jugador> jugadores = new HashMap<>();

    @Override
    public Jugador getJugador(String nombre) throws PlayerNotFoundException {
        if (jugadores.get(nombre) == null) {
            throw new PlayerNotFoundException();
        }
        return jugadores.get(nombre);
    }

    @Override
    public void actualizarJugador(Jugador jugador, String nombre) throws PlayerNotFoundException {
        getJugador(nombre);//esto es para checkar que exista el jugador
        jugadores.remove(nombre);
        jugadores.put(nombre, jugador);
    }

    @Override
    public void Atacar(Jugador jugador1, Jugador jugador2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevoJugador(Jugador jugador) throws PlayerNotFoundException{
        if (jugadores.get(jugador.getNombre()) != null){
            throw new PlayerNotFoundException();
        }
        jugadores.put(jugador.getNombre(),jugador);
    }

}
