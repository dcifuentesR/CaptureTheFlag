package edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


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