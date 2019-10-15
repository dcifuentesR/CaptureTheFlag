package edu.eci.arsw.CaptureTheFlag.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import edu.eci.arsw.CaptureTheFlag.model.Sala;
import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioUsuario;;

@Service("services")
public class CTFServices implements CaptureTheFlagServices {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public ArrayList<Cuenta> getCuentas() {
		ArrayList<Cuenta> usuarios = new ArrayList<Cuenta>();
		Iterable<Cuenta> iterator = repositorioUsuario.findAll();
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
	public Sala getPartida(String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException {
		repositorioUsuario.save(cuenta);

	}

	@Override
	public Cuenta getCuenta(Integer id) throws CaptureTheFlagException {

		return repositorioUsuario.findById(id).get();
	}

	@Override
	public Cuenta getCuenta(String nick) throws CaptureTheFlagException {
		return repositorioUsuario.findUser(nick);
	}

	@Override
	public ArrayList<Sala> getPartidas(String nombre) throws CaptureTheFlagException {
		// TODO Auto-generated method stub
		return null;
	}

}
