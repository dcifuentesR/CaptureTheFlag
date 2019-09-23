package edu.eci.arsw.CaptureTheFlag.persistence.repositorios;

import org.springframework.data.repository.CrudRepository;

import edu.eci.arsw.CaptureTheFlag.model.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario,Integer>{

}
