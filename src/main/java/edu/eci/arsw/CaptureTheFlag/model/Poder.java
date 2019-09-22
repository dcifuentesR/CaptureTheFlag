package edu.eci.arsw.CaptureTheFlag.model;

public class Poder extends Item {
	
    private int daño = 20;
    private int duracion = 1;
    
    
    public int getDaño() {
        return daño;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    
    
}
