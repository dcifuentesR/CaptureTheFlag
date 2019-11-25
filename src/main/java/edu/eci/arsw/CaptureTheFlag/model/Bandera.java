package edu.eci.arsw.CaptureTheFlag.model;

public class Bandera {

    private double x;
    private double y;
    private boolean tomada = false;

    public Bandera() {
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isTomada() {
        return tomada;
    }

    public void setTomada(boolean tomada) {
        this.tomada = tomada;
    }

    @Override
    public String toString() {
        return "Bandera {tomada=" + tomada + ", x=" + x + ", y=" + y + "}";
    }

}