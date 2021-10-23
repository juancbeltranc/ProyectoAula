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


import co.poligran.edu.proyecto.model.User;
import co.poligran.edu.proyecto.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Class: UserController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	UsuarioRepository userRepository;
	
	@GetMapping("/User")
	@ApiOperation(value = "*** Service Method Get All User ***", notes = "*** Get All Users from MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get All Users!!! ***")})
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	@ApiOperation(value = "*** Service Method getUserByID ***", notes = "*** Obtiene usuario por id consultando MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al obtener usuario!!! ***")})
	@GetMapping("/Users/{id}")
	public User getUserByID(@PathVariable String id) {
		return userRepository.findById(id).get();
	}
	@ApiOperation(value = "*** Service Method SaveUserD ***", notes = "*** Guarda usuario en bd MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al guardar usuario!!! ***")})
	@PostMapping("/User")
	public User saveUser(@RequestBody User user){
		return userRepository.save(user);
	}
	@ApiOperation(value = "*** Service Method saveListUsers ***", notes = "*** Guarda usuarios en bd MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al guardar usuarios!!! ***")})
	@PostMapping("/UsersList")
	public List<User> saveListUsers(@RequestBody List<User> users) {
		return userRepository.saveAll(users);
	}
	@ApiOperation(value = "*** Service Method updateUser ***", notes = "*** Actualiza usuarios que esten en bd MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al actualizar usuarios!!! ***")})
	@PutMapping("/Users/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		
		User _user = userRepository.findById(id).get();
		
		_user.setNombre(user.getNombre());
		_user.setApellido(user.getApellido());
		_user.setCiudad(user.getCiudad());
		_user.setDireccion(user.getDireccion());
		_user.setEmail(user.getDireccion());
		_user.setTelefono(user.getTelefono());
		
		
		userRepository.save(_user);
		
		return _user;
	}
	@ApiOperation(value = "*** Service Method deleteUserById ***", notes = "*** Elimina usuario en bd MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al eliminar usuario!!! ***")})
	@DeleteMapping("/Users/{id}")
	public User deleteUserById(@PathVariable String id) {
		User _user = userRepository.findById(id).get();
		userRepository.deleteById(id);
		return _user;
	}
	@ApiOperation(value = "*** Service Method deleteAll ***", notes = "*** Elimina usuarios en bd MongoDB\\\\Proyecta ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error al eliminar usuarios!!! ***")})
	@DeleteMapping("/UsersList")
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
