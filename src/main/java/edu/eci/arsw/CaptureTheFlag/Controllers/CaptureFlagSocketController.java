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
        // System.out.println(salas.values().toString());
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

    // jugador
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

    @MessageMapping("/vidaPj.{nombre}")
    public void setVidaPersonaje(String valor, @DestinationVariable String nombre) {
        String[] valores = valor.split(";");
        String nick = valores[0];
        int vida = Integer.parseInt(valores[1]);
        salas.get(nombre).setVidaPJ(nick, vida);
    }

    // Bala
    @MessageMapping("/createBalas.{nombre}")
    public void createBala(String valor, @DestinationVariable String nombre) {
        String[] valores = valor.split(";");
        String key = valores[0];
        String poder = valores[1];
        double x = Double.parseDouble(valores[2]);
        double y = Double.parseDouble(valores[3]);
        int dano = Integer.parseInt(valores[4]);
        salas.get(nombre).createBala(key, poder, x, y, dano);
    }

    @MessageMapping("/salaBalas.{nombre}")
    public void getBalas(@DestinationVariable String nombre) {
        msgt.convertAndSend("/topic/salaBalas." + nombre, salas.get(nombre).getBalas());
    }

    @MessageMapping("/movimientoBalas.{nombre}")
    public void movimientoBalas(String valor, @DestinationVariable String nombre) {
        String[] valores = valor.split(";");
        String key = valores[0];
        double x = Double.parseDouble(valores[1]);
        double y = Double.parseDouble(valores[2]);
        salas.get(nombre).moverBala(key, x, y);
    }

    @MessageMapping("/colisionBala.{nombre}")
    public void colisionBala(String bala, @DestinationVariable String nombre) {
        salas.get(nombre).colisionBala(bala);
    }

    // bandera
    @MessageMapping("/salaBandera.{nombre}")
    public void getBandera(@DestinationVariable String nombre) {
        msgt.convertAndSend("/topic/salaBandera." + nombre, salas.get(nombre).getBandera());
    }

    @MessageMapping("/cogerBandera.{nombre}")
    public void cogerBandera(String nick, @DestinationVariable String nombre) {
        salas.get(nombre).banderaPersonaje(nick);
    }

}
