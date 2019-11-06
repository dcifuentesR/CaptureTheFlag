package edu.eci.arsw.CaptureTheFlag.Controllers;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Datos;
import edu.eci.arsw.CaptureTheFlag.model.Sala;

@Controller
public class CaptureFlagSocketController {
    @Autowired
    SimpMessagingTemplate msgt;

    // private ConcurrentHashMap<Cuenta, Datos> datosJugador = new
    // ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Sala> salas = new ConcurrentHashMap<>();

    @MessageMapping("/createsala.{nombre}")
    public void createSalasEvent(Cuenta cuenta, @DestinationVariable String nombre) throws Exception {
        if (!salas.containsKey(nombre)) {
            ConcurrentHashMap<Cuenta, Datos> temp = new ConcurrentHashMap<>();
            temp.put(cuenta, new Datos());
            Sala salaTemp = new Sala(nombre);
            salaTemp.setMiembros(temp);
            salas.put(nombre, salaTemp);
        }
        System.out.println(salas.keys().toString());
        for (String s : salas.keySet()) {
            System.out.println("sala " + s);
        }
        msgt.convertAndSend("/topic/joinsala." + nombre, salas.get(nombre));
        msgt.convertAndSend("/topic/showsala", salas.values());
    }

    @MessageMapping("/joinsala.{nombre}")
    public void joinSalasEvent(Cuenta cuenta, @DestinationVariable String nombre) {
        Sala temp = salas.get(nombre);
        temp.addMiembro(cuenta, new Datos());
        msgt.convertAndSend("/topic/joinsala." + nombre, salas.get(nombre).getMiembrosName());
    }

    @MessageMapping("/sala.{nombre}")
    public void joinSalasEvent(@DestinationVariable String nombre) {
        msgt.convertAndSend("/topic/joinsala." + nombre, salas.get(nombre).getMiembrosName());
    }

    @MessageMapping("/showsala")
    public void showSalasEvent() {
        msgt.convertAndSend("/topic/showsala", salas.values());
    }

}