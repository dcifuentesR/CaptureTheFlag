package edu.eci.arsw.CaptureTheFlag.services;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import edu.eci.arsw.CaptureTheFlag.model.Partida;
import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Jugar;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioCuenta;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioJugar;
import edu.eci.arsw.CaptureTheFlag.persistence.repositorios.RepositorioPartida;


@Service("services")
public class CTFServices implements CaptureTheFlagServices {

    @Autowired
    private RepositorioCuenta repositorioCuenta;

    @Autowired
    private RepositorioPartida repositorioPartida;

    @Autowired
    private RepositorioJugar repositorioJugar;

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
    public void agregarCuenta(Cuenta cuenta) throws CaptureTheFlagException {
        repositorioCuenta.save(cuenta);
    }

    @Override
    public Cuenta getCuenta(Long id) throws CaptureTheFlagException {
        return repositorioCuenta.findById(id).get();
    }

    @Override
    public Cuenta getCuenta(String nick) throws CaptureTheFlagException {
        Cuenta cuenta = repositorioCuenta.findUser(nick);
        if (cuenta == null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.PlayerNotFoundException);
        }
        return cuenta;
    }

    @Override
    public Partida getPartida(Integer id) throws CaptureTheFlagException {
        /*Partida partida = repositorioPartida.findPartida(nombre);
		if (partida == null){
			throw new CaptureTheFlagException(CaptureTheFlagException.PartidaNotFound);
		}
		return partida;*/
        return null;
    }

    @Override
    public ArrayList<Partida> getPartidas() throws CaptureTheFlagException {
        ArrayList<Partida> partidas = new ArrayList<Partida>();
        Iterable<Partida> iterator = repositorioPartida.findAll();
        Iterator<Partida> it = iterator.iterator();
        while (it.hasNext()) {
            Partida partida = it.next();
            partidas.add(partida);
        }
        return partidas;
    }

    @Override
    public ArrayList<Jugar> getPartidasUsuario(String nick) throws CaptureTheFlagException {
        System.out.println(nick);
        ArrayList<Jugar> partidas = repositorioJugar.findPartidaJugador(nick);
        return partidas;
    }

    @Override
    public void registrarPartidaUsuario(Jugar jugar) throws CaptureTheFlagException {
        repositorioJugar.save(jugar);
    }

    @Override
    public void registrarPartida(Partida partida) {
        System.out.println(partida.getId());
        repositorioPartida.save(partida);
    }

    @Override
    public Partida getPartida(String nombre, String fecha) throws CaptureTheFlagException {
        return repositorioPartida.findPartida(nombre,fecha);

    }

}
