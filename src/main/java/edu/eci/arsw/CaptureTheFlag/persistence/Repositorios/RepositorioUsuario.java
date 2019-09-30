package edu.eci.arsw.CaptureTheFlag.persistence.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;

@Repository
public interface RepositorioUsuario extends CrudRepository<Cuenta,Integer>{




}