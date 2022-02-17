package it.progettofilm.rest;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import it.progettofilm.dao.FilmDao;
import it.progettofilm.dto.FilmDto;
import it.progettofilm.entity.Film;


@RestController
@RequestMapping("/film") // nome url di accesso.
// Api -> rende più leggibile lo swagger.
@Api(value="FilmRest", tags="Management del db.")
public class PersonaRest {

	Logger log = LoggerFactory.getLogger(getClass());
	FilmDao filmdao;
	
	public FilmDao getFilmdao() {
		if(filmdao == null) {
			filmdao = new FilmDao();
		}
		return filmdao;
	}

	
	// operazione che viene eseguita
	
	
	@ApiOperation(
			value="Mostra la lista di tutti i film.",
			produces="application/json",
			response = Film.class, responseContainer = "List")
	@GetMapping
	public ResponseEntity<List<Film>> trovaTutti () {
		try {
			return new ResponseEntity<List<Film>>(getFilmdao().trovaTutti(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@ApiOperation(value="Elimina un film.")	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFilm (@PathVariable int id) {
		try {
			getFilmdao().elimina(id);
			return new ResponseEntity<String>("Film con id " + id + "rimosso dalla lista", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Film con id " + id + " non è stato rimosso correttamente dalla lista", HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PostMapping
	@ApiOperation(
			value="Inserisci un film nella lista.",
			consumes = "application/json")
	public ResponseEntity<String> inserisciFilm(@RequestBody FilmDto fDto) {
	
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		
		try {
			 getFilmdao().salva(f);
			return new ResponseEntity<String>("Inserimento avvenuto con successo di : " + f , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Inserimento non avvenuto.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/{id}")
	@ApiOperation(
			value="Update di un film nella lista.",
			consumes = "application/json")
	public ResponseEntity<String> aggiornaFilm(@RequestBody FilmDto fDto, @PathVariable int id) {
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		f.setId(id);
		try {
			 getFilmdao().aggiorna(f);
			return new ResponseEntity<String>("Update avvenuto con successo di : " + f , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Update non riuscito.", HttpStatus.METHOD_FAILURE);
	}
	}
	
	@GetMapping("/byregista")
	@ApiOperation(
			value="Ricerca per regista.",
			produces = "application/json",
			response= Film.class)
	public ResponseEntity <List<Film>> cercaByRegista (@RequestParam String regista) {
		try {
			log.info("La ricerca è stata completata, controlla il risultato.");
			return new ResponseEntity<List<Film>>(getFilmdao().trovaByRegista(regista),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_NOT_ALLOWED);
		}
}
	
}
