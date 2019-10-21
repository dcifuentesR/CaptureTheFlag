package edu.eci.arsw.CaptureTheFlag.model;

import java.sql.Time;

public class Datos {
    private int kills;
    private int muertes;
    private int vida;
    private int puntos;
    private Time tbandera;

    public Datos() {
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

    public Time getTbandera() {
        return tbandera;
    }

    public void setTbandera(Time tbandera) {
        this.tbandera = tbandera;
    }

    @Override
    public String toString() {
        return "Datos{kills=" + kills + ", muertes=" + muertes + ", puntos=" + puntos + ", tbandera=" + tbandera
                + ", vida=" + vida + "}";
    }

}