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

    private String nombre;
    private Bandera bandera = new Bandera();

    public Sala() {
    }

    public Sala(String nombre) {
        this.nombre = nombre;
    }

    public void addMiembro(Cuenta miembro) {
        if (!miembros.containsKey(miembro.getNick())) {
            miembros.put(miembro.getNick(), miembro);
            Datos temp = new Datos(miembro.getNick());
            temp.setbG(bandera);
            datos.put(miembro.getNick(), temp);
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

    /*-----------------jugador --------------*/
    public void movimientoPJ(String nick, double x, double y) {
        datos.get(nick).setXY(x, y);
    }

    public void setVidaPJ(String nick, int vida) {
        datos.get(nick).setVida(vida);
    }

    public void addPuntos(String nick, int puntos) {
        datos.get(nick).setPuntos(puntos);
    }

    /*-----------------balas --------------*/
    public void createBala(String key, String poder, double x, double y, int dano) {
        Bala bala = new Bala(key, poder, x, y, dano);
        balas.put(key, bala);
    }

    public List<Bala> getBalas() {
        List<Bala> temp = new ArrayList<Bala>(balas.values());
        return temp;
    }

    public Bala getBala(String key) {
        return balas.get(key);
    }

    public void moverBala(String key, double x, double y) {
        if (balas.containsKey(key)) {
            balas.get(key).moverBala(x, y);
        }
    }

    public void colisionBala(String bala) {
        if (balas.containsKey(bala)) {
            balas.remove(bala);
        }
    }

    /*-----------------bandera --------------*/
    public void movimientoBandera(double x, double y) {
        bandera.setXY(x, y);
    }

    public void banderaPersonaje(String nick) {
        if (!bandera.isTomada()) {
            datos.get(nick).cogerBandera();
        }
    }

    public Bandera getBandera() {
        return bandera;
    }

}