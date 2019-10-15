package edu.eci.arsw.CaptureTheFlag.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import edu.eci.arsw.CaptureTheFlag.model.Partida;
import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioCuenta;

@Service("services")
public class CTFServices implements CaptureTheFlagServices {

	@Autowired
	private RepositorioCuenta repositorioCuenta;

	@Override
	public ArrayList<Cuenta> getCuentas() {
		ArrayList<Cuenta> usuarios = new ArrayList<Cuenta>();
		Iterable<Cuenta> iterator = repositorioCuenta.findAll();
		Iterator<Cuenta> it = iterator.iterator();
		while (it.hasNext()) {
			Cuenta cuenta = it.next();
			usuarios.add(cuenta);
		}
		return usuarios;
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarCuenta(Cuenta jugador, String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub

	}

	@Override
	public Partida getPartida(String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
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
	public Cuenta getCuenta(String nick) throws CaptureTheFlagException {
		Cuenta cuenta = repositorioCuenta.findUser(nick);
		if (cuenta == null){
			throw new CaptureTheFlagException(CaptureTheFlagException.PlayerNotFoundException);
		}
		return cuenta;
	}

	@Override
	public ArrayList<Partida> getPartidas(String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}

}
