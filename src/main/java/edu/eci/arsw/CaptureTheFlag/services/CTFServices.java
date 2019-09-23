package edu.eci.arsw.CaptureTheFlag.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Sala;
import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.CorreoAlredyExist;
import edu.eci.arsw.CaptureTheFlag.persistence.CorreoNotFound;
import edu.eci.arsw.CaptureTheFlag.persistence.LobbyNotFoundException;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerAlreadyExist;
import edu.eci.arsw.CaptureTheFlag.persistence.PlayerNotFoundException;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioCuenta;

@Service("services")
public class CTFServices implements CaptureTheFlagServices {
	
	@Autowired
	private RepositorioCuenta repositorioCuenta;

	@Override
	public Jugador getJugador(String nombre) throws PlayerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Jugador> getJugadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarJugador(Jugador jugador, String nombre) throws PlayerNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void Atacar(Jugador jugador1, Jugador jugador2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nuevoJugador(Jugador jugador) throws PlayerAlreadyExist {
		// TODO Auto-generated method stub

	}

	@Override
	public Sala getSala(String nombre) throws LobbyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarJugadorSala(Jugador jugador, String sala) throws LobbyNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarCuenta(Cuenta cuenta) throws CorreoAlredyExist {
		repositorioCuenta.save(cuenta);

	}

	@Override
	public Cuenta getCuenta(Integer id) throws CorreoNotFound {
		
		return repositorioCuenta.findById(id).get();
	}

	@Override
	public Cuenta getCuenta(String correo) throws CorreoNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
