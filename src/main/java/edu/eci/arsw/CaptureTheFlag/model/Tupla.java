package edu.eci.arsw.CaptureTheFlag.model;

public class Tupla {
    private Cuenta cuenta;
    private Datos datos;

    public Tupla(Cuenta cuenta, Datos datos) {
        this.cuenta = cuenta;
        this.datos = datos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }
}