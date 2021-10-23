package co.poligran.edu.proyecto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.poligran.edu.proyecto.model.Campania;

public interface CampaniaRepository extends MongoRepository<Campania, String>{

}
