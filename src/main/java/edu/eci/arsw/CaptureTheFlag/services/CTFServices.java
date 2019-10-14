package edu.eci.arsw.CaptureTheFlag.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.CaptureTheFlag.model.Jugador;
import edu.eci.arsw.CaptureTheFlag.model.Sala;
import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioCuenta;

@Service("services")
public class CTFServices implements CaptureTheFlagServices {
	
	@Autowired
	private RepositorioCuenta repositorioCuenta;

	@Override
	public Jugador getJugador(String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Jugador> getJugadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarJugador(Jugador jugador, String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub

	}

	@Override
	public void Atacar(Jugador jugador1, Jugador jugador2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nuevoJugador(Jugador jugador) throws CaptureTheFlagException {
		// TODO Auto-generated method stub

	}

	@Override
	public Sala getSala(String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarJugadorSala(Jugador jugador, String sala) throws CaptureTheFlagException {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException {
		repositorioCuenta.save(cuenta);

	}

	@Override
	public Cuenta getCuenta(Integer id) throws CaptureTheFlagException {
		
		return repositorioCuenta.findById(id).get();
	}

	@Override
	public Cuenta getCuenta(String correo) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}

}
