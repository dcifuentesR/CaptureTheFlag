package edu.eci.arsw.CaptureTheFlag.persistence.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.CaptureTheFlag.model.Jugar;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepositorioJugar extends CrudRepository<Jugar, Integer> {

   /* @Query("SELECT p FROM Cuenta p WHERE p.nombre = :nombre")
    Partida findPartida(@Param("nombre") String nombre);
*/
    @Query(
  value = "select * from partida as p, jugar as j, cuenta as c where c.nick = :nick and c.id = j.cuentaid and j.partidaid = p.id", 
  nativeQuery = true)
    ArrayList<Jugar>  findPartidaJugador(@Param("nick") String nombre);
    
}


