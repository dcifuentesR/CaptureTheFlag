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
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
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
    public Jugador getJugador(String nombre) throws CaptureTheFlagException {
        if (jugadores.get(nombre) == null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.PlayerNotFoundException);
        }
        return jugadores.get(nombre);
    }

    @Override
    public void actualizarJugador(Jugador jugador, String nombre) throws CaptureTheFlagException {
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
    public void nuevoJugador(Jugador jugador) throws CaptureTheFlagException {
        if (jugadores.get(jugador.getNombre()) != null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.PlayerAlreadyExist);
        }
        jugadores.put(jugador.getNombre(), jugador);
    }

    @Override
    public Sala getSala(String nombre) throws CaptureTheFlagException {
        if (salas.get(nombre) == null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.LobbyNotFound);
        }
        return salas.get(nombre);
    }

    @Override
    public void agregarJugadorSala(Jugador jugador, String sala) throws CaptureTheFlagException {
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
    public void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException {
        if (cuentas.get(cuenta.getCorreo()) != null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.CorreoAlreadyExist);
        }
        
        cuentas.put(cuenta.getCorreo(), cuenta);
    }

    @Override
    public Cuenta getCuenta(String correo) throws CaptureTheFlagException {
        if (cuentas.get(correo) == null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.CorreoNotFound);
        }
        return cuentas.get(correo);
    }

	@Override
	public Cuenta getCuenta(Integer id) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}
}
