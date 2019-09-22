package edu.eci.arsw.CaptureTheFlag.model;

public class Jugador {

    private Mira mira;
    private String nombre;
    private Integer x;
    private Integer y;
    private Integer vida;
    private Poder poder;

    public Jugador( String nombre) {
        this.nombre = nombre;
    }

    
    
    
    
    
    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Mira getMira() {
        return mira;
    }

    public void setMira(Mira mira) {
        this.mira = mira;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Poder getPoder() {
        return poder;
    }

    public void setPoder(Poder poder) {
        this.poder = poder;
    }

    public void atacar(Jugador jugador2) {
        


    }
}
