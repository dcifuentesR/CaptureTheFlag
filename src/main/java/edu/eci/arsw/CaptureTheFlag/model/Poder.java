package edu.eci.arsw.CaptureTheFlag.model;

public class Poder extends Item {
	
    private int damage = 20;
    private int duracion = 1;
    
    
    public int getDamage() {
        return damage;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
    
}
