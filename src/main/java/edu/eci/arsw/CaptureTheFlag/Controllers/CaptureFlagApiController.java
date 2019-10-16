/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.CaptureTheFlag.Controllers;

import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Jugar;
import edu.eci.arsw.CaptureTheFlag.model.Partida;
import edu.eci.arsw.CaptureTheFlag.persistence.exception.CaptureTheFlagException;

import edu.eci.arsw.CaptureTheFlag.services.CaptureTheFlagServices;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
public class CaptureFlagApiController {

    @Autowired
    CaptureTheFlagServices services;


    @RequestMapping(method = GET, value = "/cuentas")
    public ResponseEntity<?> getCuentas() {
        try {
            //obtener datos que se enviaran a traves del API
            ArrayList<Cuenta> usuarios = new ArrayList<Cuenta>();
            usuarios = services.getCuentas();
            return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = GET, value = "/cuentas/{nick}")
    public ResponseEntity<?> getCuenta(@PathVariable(name = "nick") String nick) {
        try {
            //obtener datos que se enviaran a traves del API
            Cuenta cuenta = services.getCuenta(nick);
            return new ResponseEntity<>(cuenta, HttpStatus.ACCEPTED);

        } catch (CaptureTheFlagException ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/cuentas", method = POST)
    public ResponseEntity<?> addCuenta(@RequestBody Cuenta cuenta
    ) {
        try {
            services.agregarCuenta(cuenta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CaptureTheFlagException ex) {
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = GET, value = "/partidas")
    public ResponseEntity<?> getPartidas() {
        try {
            //obtener datos que se enviaran a traves del API
            ArrayList<Partida> partidas = new ArrayList<Partida>();
            partidas = services.getPartidas();
            return new ResponseEntity<>(partidas, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/partidas", method = POST)
    public ResponseEntity<?> addPartida(@RequestBody Partida partida) {
        try {
            services.registrarPartida(partida);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("ERROR 403", HttpStatus.FORBIDDEN);
        }
    }
    
    @RequestMapping(method = GET, value = "/cuentas/{nick}/partidas")
    public ResponseEntity<?> getPartidasUsuario(@PathVariable(name = "nick") String nick) {
        try {
            ArrayList<Jugar> partidas = services.getPartidasUsuario(nick);
            return new ResponseEntity<>(partidas, HttpStatus.ACCEPTED);

        } catch (CaptureTheFlagException ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = POST, value = "/cuentas/{nick}/partidas")
    public ResponseEntity<?> registarPartidaUsuario(@RequestBody Jugar jugar,@PathVariable(name = "nick") String nick) {
        try {
            System.out.println(jugar);
            services.registrarPartidaUsuario(jugar);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }   
    }
    
}
