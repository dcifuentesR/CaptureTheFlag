package edu.eci.arsw.CaptureTheFlag.model;

import java.io.Serializable;
import java.sql.Time;


import javax.persistence.*;

@Entity
public class Partida implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fecha;
    private String nombre;

    public Partida(String fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public Partida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
