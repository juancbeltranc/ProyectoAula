package co.poligran.edu.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.poligran.edu.proyecto.model.Campania;
import co.poligran.edu.proyecto.repository.CampaniaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Class: CampaniaController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class CampaniaController {
	
	@Autowired
	CampaniaRepository campaniaRepository;
	
	@GetMapping("/Campania")
	@ApiOperation(value = "*** Service Method Get All Campanias ***", notes = "*** Get All Campanias from MongoDB\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get All Campanias!!! ***")})
	public List<Campania> getAllCampanias(){
		return campaniaRepository.findAll();
	}
	@ApiOperation(value = "*** Service Method Get id campaña ***", notes = "*** Obtiene campañas por id desde mongodb\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al obtener campaña!!! ***")})
	@GetMapping("/Campanias/{id}")
	public Campania getCampaniaByID(@PathVariable String id) {
		return campaniaRepository.findById(id).get();
	}
	@ApiOperation(value = "*** Service Method post saveCampania ***", notes = "*** Agrega campaña una a una desde mongodb\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al agregar campaña!!! ***")})
	@PostMapping("/Campanias")
	public Campania saveCampania(@RequestBody Campania campania){
		return campaniaRepository.save(campania);
	}
	@ApiOperation(value = "*** Service Method post saveListCampanias ***", notes = "*** Agrega campaña en lista desde mongodb\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al agregar las campañas!!! ***")})
	@PostMapping("/CampaniasList")
	public List<Campania> saveListCampanias(@RequestBody List<Campania> campanias) {
		return campaniaRepository.saveAll(campanias);
	}
	
	@ApiOperation(value = "*** Service Method post updateCampanias ***", notes = "*** Actualiza campañas en mongodb\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al actualizar las campañas!!! ***")})
	@PutMapping("/Campanias/{id}")
	public Campania updateCampania(@PathVariable String id, @RequestBody Campania campania) {
		
		Campania _campania = campaniaRepository.findById(id).get();
		
		_campania.setNombre(campania.getNombre());
		_campania.setAnio(campania.getAnio());
		_campania.setMes(campania.getMes());
		_campania.setDia(campania.getDia());
		
		
		campaniaRepository.save(_campania);
		
		return _campania;
	}
	
	@ApiOperation(value = "*** Service Method Delete deleteCampaniaById ***", notes = "*** Elimina campaña por id en mongodb\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al eliminar la campaña!!! ***")})
	@DeleteMapping("/Campanias/{id}")
	public Campania deleteCampaniaById(@PathVariable String id) {
		Campania _campania = campaniaRepository.findById(id).get();
		campaniaRepository.deleteById(id);
		return _campania;
	}
	@ApiOperation(value = "*** Service Method deleteAll ***", notes = "*** Elimina campañas en mongodb\\\\Proyecto ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al eliminar las campañas!!! ***")})
	@DeleteMapping("/CampaniasList")
	public void deleteAll() {
		campaniaRepository.deleteAll();
	}

}
