package edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario;

public class Cuenta {
    private String correo;
    private String contrasena;
    private String nick;

    public Cuenta() {
    }

    public Cuenta(String correo, String contrasena, String nick) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nick = nick;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}