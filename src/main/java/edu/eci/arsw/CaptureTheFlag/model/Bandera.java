package edu.eci.arsw.CaptureTheFlag.model;

public class Bandera extends Item {

  
    private static int puntaje;

    

    
    public static int getPuntaje() {
        return puntaje;
    }

    public static void setPuntaje(int puntaje) {
        Bandera.puntaje = puntaje;
    }
    
    
}
