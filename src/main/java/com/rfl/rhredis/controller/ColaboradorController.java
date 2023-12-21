package com.rfl.rhredis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rfl.rhredis.model.Colaborador;
import com.rfl.rhredis.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@GetMapping
	public ResponseEntity<List<Colaborador>> getAll() {
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		colaboradorRepository.findAll().forEach(colaboradores::add);
		return ResponseEntity.ok(colaboradores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> getById(@PathVariable Integer id) {
		return colaboradorRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Colaborador> post(@RequestBody Colaborador colaborador) {
		return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorRepository.save(colaborador));
	}

	@PutMapping
    public ResponseEntity<Colaborador> put(@RequestBody Colaborador colaborador){
        return colaboradorRepository.findById(colaborador.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.OK)
            .body(colaboradorRepository.save(colaborador)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);

		if (colaborador.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		colaboradorRepository.deleteById(id);
	}
}
