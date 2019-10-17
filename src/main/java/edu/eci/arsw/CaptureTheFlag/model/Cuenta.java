package edu.eci.arsw.CaptureTheFlag.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Cuenta implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String correo;
    private String contrasena;
    private String nick;

    /* @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private Set<Jugar> jugar = new HashSet<>();*/
    public Cuenta(String correo, String contrasena, String nick) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nick = nick;
    }

    public Cuenta() {
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

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
