package edu.eci.arsw.CaptureTheFlag.persistence.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.CaptureTheFlag.model.Jugar;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepositorioJugar extends CrudRepository<Jugar, Long> {

    @Query(
  value = "select j from Partida as p, Jugar as j, Cuenta as c where c.nick = :nick and c.id = j.cuenta and j.partida = p.id")
    ArrayList<Jugar>  findPartidaJugador(@Param("nick") String nombre);
    
}


