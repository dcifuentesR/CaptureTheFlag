package edu.eci.arsw.CaptureTheFlag.model;

//import java.sql.Time;

public class Datos {
    private int kills = 0;
    private int muertes = 0;
    private int vida = 100;
    private int puntos = 0;
    // private Time tbandera;
    private double x;
    private double y;
    private String nick;

    public Datos() {
    }

    public Datos(String nick) {
        this.nick = nick;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Datos{kills=" + kills + ", muertes=" + muertes + ", nick=" + nick + ", puntos=" + puntos + ", vida="
                + vida + ", x=" + x + ", y=" + y + "}";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}