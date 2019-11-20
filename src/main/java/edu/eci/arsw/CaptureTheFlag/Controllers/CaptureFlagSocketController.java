package edu.eci.arsw.CaptureTheFlag.Controllers;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.CaptureTheFlag.model.Cuenta;
import edu.eci.arsw.CaptureTheFlag.model.Sala;


@Controller
public class CaptureFlagSocketController {
    @Autowired
    SimpMessagingTemplate msgt;

    private ConcurrentHashMap<String, Sala> salas = new ConcurrentHashMap<>();

    // ------------------ controladores de la sala----------------------------//

    @MessageMapping("/createsala.{nombre}")
    public void createSalasEvent(Cuenta cuenta, @DestinationVariable String nombre) throws Exception {
        if (!salas.containsKey(nombre)) {
            Sala sala = new Sala(nombre);
            sala.addMiembro(cuenta);
            salas.put(nombre, sala);
        }
        //System.out.println(salas.values().toString());
        msgt.convertAndSend("/topic/joinsala." + nombre, salas.get(nombre));
        msgt.convertAndSend("/topic/showsala", salas.values());
    }

    @MessageMapping("/joinsala.{nombre}")
    public void joinSalasEvent(Cuenta cuenta, @DestinationVariable String nombre) {
        Sala temp = salas.get(nombre);
        temp.addMiembro(cuenta);
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

    // ------------------ controladores de la partida-----------------------------//

    @MessageMapping("/salaMovimiento.{nombre}")
    public void movimientos(String val, @DestinationVariable String nombre) {
        String temp = val;
        String[] valores = temp.split(";");
        String nick = valores[0];
        double x = Double.parseDouble(valores[1]);
        double y = Double.parseDouble(valores[2]);
        // System.out.println(nick + " " + x + " " + y);

        // System.out.print(salas.get(nombre));
        salas.get(nombre).movimientoPJ(nick, x, y);
        // msgt.convertAndSend("/topic/salaDatos." + nombre,
        // salas.get(nombre).getDatos());

    }

    @MessageMapping("/salaDatos.{nombre}")
    public void getDatos(@DestinationVariable String nombre) {
        msgt.convertAndSend("/topic/salaDatos." + nombre, salas.get(nombre).getDatos());

    }

    @MessageMapping("/salaDatosRefrescar.{nombre}")
    public void getDatosRefrescar(@DestinationVariable String nombre) {
        msgt.convertAndSend("/topic/salaDatos." + nombre, salas.get(nombre).getDatos());

    }

}
