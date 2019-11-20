package edu.eci.arsw.CaptureTheFlag.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Sala {

    // ConcurrentHashMap<Cuenta, Datos> miembros = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Tupla> miembros = new ConcurrentHashMap<>();
    String nombre;

    public Sala() {
    }

    public Sala(String nombre) {
        this.nombre = nombre;
    }

    public void addMiembro(Cuenta miembro, Datos datos) {
        Tupla temp = new Tupla(miembro, datos);
        miembros.put(miembro.getNick(), temp);
    }

    public ConcurrentHashMap<String, Tupla> getMiembros() {
        return miembros;
    }

    public List<Datos> getDatos() {
        List<Datos> temp2 = new ArrayList<Datos>();
        for (Tupla t : miembros.values()) {
            temp2.add(t.getDatos());
        }
        return temp2;
    }

    public List<Cuenta> getMiembrosName() {
        List<Cuenta> temp = new ArrayList<Cuenta>();
        for (Tupla t : miembros.values()) {
            temp.add(t.getCuenta());
        }
        return temp;
    }

    public void setMiembros(ConcurrentHashMap<String, Tupla> miembros) {
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

    public void movimientoPJ(String nick, double x, double y) {
        miembros.get(nick).getDatos().setXY(x, y);
    }

}