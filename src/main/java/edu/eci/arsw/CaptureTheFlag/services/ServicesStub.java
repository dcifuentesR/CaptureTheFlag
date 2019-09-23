/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Mira;
import edu.eci.arsw.CaptureTheFlag.model.Poder;
import edu.eci.arsw.CaptureTheFlag.model.Sala;
import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.CorreoAlredyExist;
import edu.eci.arsw.CaptureTheFlag.persistence.CorreoNotFound;
import edu.eci.arsw.CaptureTheFlag.persistence.LobbyNotFoundException;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerAlreadyExist;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServicesStub implements CaptureTheFlagServices {

    HashMap<String, Jugador> jugadores = new HashMap<>();
    HashMap<String, Sala> salas = new HashMap<>();
    HashMap<String, Cuenta> cuentas = new HashMap<>();

    public ServicesStub() {
        jugadores.put("diego", new Jugador("diego"));
        jugadores.put("andres", new Jugador("andres"));
        cuentas.put("andres", new Cuenta("andres","123","andres"));
    }

    @Override
    public Jugador getJugador(String nombre) throws PlayerNotFoundException {
        if (jugadores.get(nombre) == null) {
            throw new PlayerNotFoundException();
        }
        return jugadores.get(nombre);
    }

    @Override
    public void actualizarJugador(Jugador jugador, String nombre) throws PlayerNotFoundException {
        getJugador(nombre);// esto es para checkar que exista el jugador
        jugadores.remove(nombre);
        jugadores.put(nombre, jugador);
    }

    @Override
    public void Atacar(Jugador jugador1, Jugador jugador2) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    @Override
    public void nuevoJugador(Jugador jugador) throws PlayerAlreadyExist {
        if (jugadores.get(jugador.getNombre()) != null) {
            throw new PlayerAlreadyExist();
        }
        jugadores.put(jugador.getNombre(), jugador);
    }

    @Override
    public Sala getSala(String nombre) throws LobbyNotFoundException {
        if (salas.get(nombre) == null) {
            throw new LobbyNotFoundException();
        }
        return salas.get(nombre);
    }

    @Override
    public void agregarJugadorSala(Jugador jugador, String sala) throws LobbyNotFoundException {
        Sala s = getSala(sala);
        s.getJugadores().put(sala, jugador);
    }

    @Override
    public ArrayList<Jugador> getJugadores() {
        ArrayList<Jugador> j = new ArrayList<>();
        j.addAll(jugadores.values());
        return j;

    }

    @Override
    public void agregarCuenta(Cuenta cuenta) throws CorreoAlredyExist {
        if (cuentas.get(cuenta.getCorreo()) != null) {
            throw new CorreoAlredyExist();
        }
        
        cuentas.put(cuenta.getCorreo(), cuenta);
    }

    @Override
    public Cuenta getCuenta(String correo) throws CorreoNotFound {
        if (cuentas.get(correo) == null) {
            throw new CorreoNotFound();
        }
        return cuentas.get(correo);
    }

	@Override
	public Cuenta getCuenta(Integer id) throws CorreoNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
