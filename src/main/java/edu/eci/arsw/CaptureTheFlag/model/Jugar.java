package edu.eci.arsw.CaptureTheFlag.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(JugarId.class)
public class Jugar implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

     
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "cuenta_id", nullable = false, insertable = false, updatable = false)
    Cuenta cuenta;

    @Id 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "partida_id", nullable = false, insertable = false, updatable = false)
    Partida partida;

    private int kills;
    private int muertes;
    private Integer posicion; 
    private Integer puntos; 

  
    
    public Jugar(Cuenta cuenta, Partida partida, int kills, int muertes, Integer posicion, Integer puntos) {
        this.kills = kills;
        this.muertes = muertes;
        this.posicion = posicion;
        this.puntos = puntos;
    }
    
    public Jugar(){
    
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
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
    
    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

}
