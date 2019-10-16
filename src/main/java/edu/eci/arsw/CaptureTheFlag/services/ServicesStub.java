/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.CaptureTheFlag.services;

import edu.eci.arsw.CaptureTheFlag.model.Partida;
import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Jugar;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

public class ServicesStub implements CaptureTheFlagServices {

    HashMap<String, Cuenta> jugadores = new HashMap<>();
    HashMap<String, Partida> salas = new HashMap<>();
    HashMap<String, Cuenta> cuentas = new HashMap<>();

    public ServicesStub() {
        jugadores.put("diego", new Cuenta("diego", "123", "diego"));
        jugadores.put("andres", new Cuenta("felipe", "123", "felipe"));
        cuentas.put("andres", new Cuenta("andres", "123", "andres"));
    }

    @Override
    public void actualizarCuenta(Cuenta jugador, String nombre) throws CaptureTheFlagException {
        getCuenta(nombre);// esto es para checkar que exista el jugador
        jugadores.remove(nombre);
        jugadores.put(nombre, jugador);
    }

    @Override
    public Partida getPartida(Integer id) throws CaptureTheFlagException {
        if (salas.get(id) == null) {
            throw new CaptureTheFlagException(CaptureTheFlagException.PartidaNotFound);
        }
        return salas.get(id);
    }

    @Override
    public ArrayList<Cuenta> getCuentas() {
        ArrayList<Cuenta> j = new ArrayList<>();
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
    public Cuenta getCuenta(Long id) throws CaptureTheFlagException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Partida> getPartidas() throws CaptureTheFlagException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Jugar> getPartidasUsuario(String nick) throws CaptureTheFlagException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void registrarPartidaUsuario(Jugar jugar) throws CaptureTheFlagException {
        // TODO Auto-generated method stub

    }

    @Override
    public void registrarPartida(Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
