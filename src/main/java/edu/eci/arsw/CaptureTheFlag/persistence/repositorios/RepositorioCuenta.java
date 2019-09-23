package edu.eci.arsw.CaptureTheFlag.persistence.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.eci.arsw.CaptureTheFlag.model.cuentaUsuario.Cuenta;

public interface RepositorioCuenta extends CrudRepository<Cuenta, Integer> {

}
