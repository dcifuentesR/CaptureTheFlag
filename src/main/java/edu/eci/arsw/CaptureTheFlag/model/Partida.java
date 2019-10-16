package edu.eci.arsw.CaptureTheFlag.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.*;

@Entity
public class Partida implements Serializable  {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Time duracion;
    
   /* @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL)
    private Set<Jugar> jugar;*/

    public Partida(Time duracion) {
        this.duracion = duracion;
    }

    public Partida() {
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Set<Jugar> getJugar() {
        return jugar;
    }

    public void setJugar(Set<Jugar> jugar) {
        this.jugar = jugar;
    }*/

}
