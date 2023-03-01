package com.ista.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.web.entity.Depto;
import com.ista.springboot.web.service.IDeptoService;


@RestController
@RequestMapping("/api/Depto")
public class DeptoController {

	@Autowired
	IDeptoService DeptoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Depto>> listarDepto() {
		return new ResponseEntity<>(DeptoService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Depto> crearDepto(@RequestBody Depto p) {
		return new ResponseEntity<>(DeptoService.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Depto> actualizarDepto(@PathVariable Long id, @RequestBody Depto p) {
		Depto DeptoENcontrada = DeptoService.findById(id);
		if (DeptoENcontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				DeptoENcontrada.setNombre(p.getNombre());
				DeptoENcontrada.setDirector(p.getDirector());
				DeptoENcontrada.setDescripcion(p.getDescripcion());
				return new ResponseEntity<>(DeptoService.save(p), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Depto> eliminarDepto(@PathVariable Long id) {
		DeptoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
