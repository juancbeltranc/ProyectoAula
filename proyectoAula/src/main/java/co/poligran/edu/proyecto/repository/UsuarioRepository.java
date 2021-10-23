package co.poligran.edu.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.poligran.edu.proyecto.model.User;

public interface UsuarioRepository extends MongoRepository<User, String> {

}
