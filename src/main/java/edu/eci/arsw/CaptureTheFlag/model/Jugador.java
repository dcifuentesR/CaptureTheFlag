package edu.eci.arsw.CaptureTheFlag.model;

public class Jugador {

	private String nombre;
	
	private boolean cayendose;
	private boolean saltando;
	
    private Integer velX;
    private Integer velY;
    private Integer x;
    private Integer y;
    private Integer vida;
    
    private Mira mira;
    private Poder poder;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador() {
    }
    
    public void mover() {
    	x+=velX;
    	x+=velY;
    	
    	
    }
    
    public void atacar(Jugador jugador2) {

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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
