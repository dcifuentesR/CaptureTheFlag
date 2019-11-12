package edu.eci.arsw.CaptureTheFlag.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Sala {

    ConcurrentHashMap<Cuenta, Datos> miembros = new ConcurrentHashMap<>();
    String nombre;

    public Sala() {
    }

    public Sala(String nombre) {
        this.nombre = nombre;
    }

    public void addMiembro(Cuenta miembro, Datos datos) {
        miembros.put(miembro, datos);
    }

    public ConcurrentHashMap<Cuenta, Datos> getMiembros() {
        return miembros;
    }

    public List<Datos> getDatos() {
        List<Datos> temp = new ArrayList<Datos>(miembros.values());
        return temp;
    }

    public List<Cuenta> getMiembrosName() {
        List<Cuenta> temp = new ArrayList<Cuenta>(miembros.keySet());
        return temp;
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

    public void movimientoPJ(String nick, double x, double y) {
        for (Cuenta c : miembros.keySet()) {
            if (c.getNick().equals(nick)) {
                miembros.get(c).setXY(x, y);
            }
        }
    }

}