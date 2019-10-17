package edu.eci.arsw.CaptureTheFlag.Controllers;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import edu.eci.arsw.CaptureTheFlag.model.Cuenta;

@Controller
public class CaptureFlagSocketController {
    @Autowired
    SimpMessagingTemplate msgt;

    private ConcurrentHashMap<String, List<Cuenta>> salas = new ConcurrentHashMap<>();

    @MessageMapping("/sala.{nombre}")
    public void handleSalasEvent() throws Exception {

    }
}