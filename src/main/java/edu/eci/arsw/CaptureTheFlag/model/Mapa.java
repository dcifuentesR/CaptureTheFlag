package edu.eci.arsw.CaptureTheFlag.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Mapa {
	
	private Integer id;
	
	private String nombre;
	
	
	private float gravedad;
	
	private Plataforma[] plataformas;
	
	private List<Item>	items;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the gravedad
	 */
	public float getGravedad() {
		return gravedad;
	}

	/**
	 * @return the plataformas
	 */
	public Plataforma[] getPlataformas() {
		return plataformas;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param gravedad the gravedad to set
	 */
	public void setGravedad(float gravedad) {
		this.gravedad = gravedad;
	}

	/**
	 * @param plataformas the plataformas to set
	 */
	public void setPlataformas(Plataforma[] plataformas) {
		this.plataformas = plataformas;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}
