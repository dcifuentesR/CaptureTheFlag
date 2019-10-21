package edu.eci.arsw.CaptureTheFlag.model;

import java.util.concurrent.ConcurrentHashMap;

public class Sala {

    ConcurrentHashMap<Cuenta, Datos> miembros = new ConcurrentHashMap<>();
    String nombre;
    

    public Sala() {
    }

    public Sala(String nombre) {
        this.nombre=nombre;
    }

    public void addMiembro (Cuenta miembro, Datos datos){
        miembros.put(miembro, datos);
    }

    public ConcurrentHashMap<Cuenta, Datos> getMiembros() {
        return miembros;
    }

    public void setMiembros(ConcurrentHashMap<Cuenta, Datos> miembros) {
        this.miembros = miembros;
    }

    @Override
    public String toString() {
        return "Sala{miembros=" + miembros + ", nombre=" + nombre + "}";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}