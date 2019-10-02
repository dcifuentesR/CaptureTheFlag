package edu.eci.arsw.CaptureTheFlag.persistence.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RepositorioUsuario extends CrudRepository<Cuenta, Integer> {

   @Query("SELECT c FROM Cuenta c    WHERE c.nick = :nick")
    Cuenta findUser(@Param("nick") String correo);

}
