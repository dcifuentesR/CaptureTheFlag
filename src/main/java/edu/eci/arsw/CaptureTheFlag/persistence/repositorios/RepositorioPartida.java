package edu.eci.arsw.CaptureTheFlag.persistence.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.CaptureTheFlag.model.Partida;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepositorioPartida extends CrudRepository<Partida, Integer> {

   /* @Query("SELECT p FROM Cuenta p WHERE p.nombre = :nombre")
    Partida findPartida(@Param("nombre") String nombre);
*/

}