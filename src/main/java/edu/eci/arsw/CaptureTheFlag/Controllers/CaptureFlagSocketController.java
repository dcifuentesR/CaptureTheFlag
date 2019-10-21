package edu.eci.arsw.CaptureTheFlag.Controllers;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Datos;

@Controller
public class CaptureFlagSocketController {
    @Autowired
    SimpMessagingTemplate msgt;

    // private ConcurrentHashMap<Cuenta, Datos> datosJugador = new
    // ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ConcurrentHashMap<Cuenta, Datos>> salas = new ConcurrentHashMap<>();

    @MessageMapping("/createsala.{nombre}")
    public void createSalasEvent(Cuenta cuenta, @DestinationVariable String nombre) throws Exception {
        System.out.println("entraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(nombre);
        if (!salas.containsKey(nombre)) {
            ConcurrentHashMap<Cuenta, Datos> temp = new ConcurrentHashMap<>();
            temp.put(cuenta, new Datos());
            salas.put(nombre, temp);
        }
        System.out.println(salas.keys().toString());
        for (String s : salas.keySet()) {
            System.out.println("sala " + s);
        }
        msgt.convertAndSend("/topic/joinsala." + nombre, salas.get(nombre));
    }

    @MessageMapping("/joinsala.{nombre}")
    public void joinSalasEvent(Cuenta cuenta, @DestinationVariable String nombre) {
        ConcurrentHashMap<Cuenta, Datos> temp = salas.get(nombre);
        temp.put(cuenta, new Datos());
        msgt.convertAndSend("/topic/joinsala." + nombre, salas.get(nombre));
    }

    @MessageMapping("/showsala")
    public void showSalasEvent() {
        System.out.println("showSalasEvent oooooooooooooooooooooooooooooooooooooooooooooo");
        msgt.convertAndSend("/topic/showsala", salas);
    }
}