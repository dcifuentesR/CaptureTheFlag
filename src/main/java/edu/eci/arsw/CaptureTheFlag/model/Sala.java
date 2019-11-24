package edu.eci.arsw.CaptureTheFlag.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Sala {

    // ConcurrentHashMap<Cuenta, Datos> miembros = new ConcurrentHashMap<>();
    // ConcurrentHashMap<String, Tupla> miembros = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Datos> datos = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Cuenta> miembros = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Bala> balas = new ConcurrentHashMap<>();

    String nombre;

    public Sala() {
    }

    public Sala(String nombre) {
        this.nombre = nombre;
    }

    public void addMiembro(Cuenta miembro) {
        if (!miembros.containsKey(miembro.getNick())) {
            miembros.put(miembro.getNick(), miembro);
            datos.put(miembro.getNick(), new Datos(miembro.getNick()));
        }
    }

    public List<Datos> getDatos() {
        List<Datos> temp = new ArrayList<Datos>(datos.values());
        return temp;
    }

    public List<Cuenta> getMiembrosName() {
        List<Cuenta> temp = new ArrayList<Cuenta>(miembros.values());
        return temp;
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
        datos.get(nick).setXY(x, y);
    }

    /*-----------------balas --------------*/
    public void createBala(String key, String poder, double x, double y, int dano) {
        Bala bala = new Bala(poder, x, y, dano);
        balas.put(key, bala);
    }

    public List<Bala> getBalas() {
        List<Bala> temp = new ArrayList<Bala>(balas.values());
        return temp;
    }

}