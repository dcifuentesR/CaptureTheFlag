package edu.eci.arsw.CaptureTheFlag.model;
import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Partida implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre; 
    private Time duracion;


    public Partida(String nombre, Time duracion){
        this.nombre = nombre;
        this.duracion = duracion;
    }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}