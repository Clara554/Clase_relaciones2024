package py.edu.facitec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

//Aplicar la Arquitectura rest
//Representation State Transfer
//Solicitud sin alm de estado.
@RestController
@RequestMapping("/api")
//api afecta a todos los metodos de la clase.
public class SuscritoController {

	// Autowired de Suscrito Repository

	@Autowired
	private SuscritoRepository suscritoRepository;

	// api
	@GetMapping("/suscritos")
	public ResponseEntity<List<Suscrito>> getSuscritos() {

		List<Suscrito> suscritos = new ArrayList<>();

		// Buscar todos
		suscritos = suscritoRepository.findAll();
		// ResponseEntity<body, status>
		return new ResponseEntity<List<Suscrito>>(suscritos, HttpStatus.OK);

	}

	// Post se utiliza para crear un elemento.
	@PostMapping("/suscrito")
	public ResponseEntity<Suscrito>
			// JSON --> JAVA
			guardarSuscrito(@RequestBody Suscrito suscrito) {
		suscritoRepository.save(suscrito);
		return new ResponseEntity
		// Devolver el objeto nuevo creado
		// id nuevo
		<Suscrito>(suscrito, HttpStatus.OK);

	}

	// Consulta Api/suscrito/{codigo}
	// Buscar un suscrito por codigo

	@GetMapping("/suscrito/{codigo}")
	// Recibir por parametro el valor
	public ResponseEntity<Suscrito> getOneSuscrito(@PathVariable Long codigo) {

		Optional<Suscrito> suscrito = suscritoRepository.findById(codigo);

		// Comparar si se encontro
		if (suscrito.isPresent()) {
			return new ResponseEntity<Suscrito>(suscrito.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	// api/suscrito/id
	// Eliminar un suscrito por codigo Delete
	@DeleteMapping("/suscrito/{codigo}")
	// Recibir por parametro el valor
	public ResponseEntity<Suscrito> eliminarOneSuscrito(@PathVariable Long codigo) {

		Optional<Suscrito> suscrito = suscritoRepository.findById(codigo);

		// Comparar si se encontro
		if (suscrito.isPresent()) {
			
			//Elimina un suscrito
			suscritoRepository.deleteById(codigo);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

}
