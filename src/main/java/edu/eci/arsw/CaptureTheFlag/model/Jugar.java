package edu.eci.arsw.CaptureTheFlag.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@IdClass(Jugar.class)
public class Jugar implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn 
    private Cuenta cuenta;

    @Id
    @ManyToOne
    @JoinColumn 
    private Partida partida;

    private int kills;
    private int muertes;
    private Time tbandera;
    
    public Jugar(Cuenta cuenta, int kills, int muertes, Time tbandera) {
        this.kills = kills;
        this.muertes = muertes;
        this.tbandera = tbandera;
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

    public Time getTbandera() {
        return tbandera;
    }

    public void setTbandera(Time tbandera) {
        this.tbandera = tbandera;
    }

}
