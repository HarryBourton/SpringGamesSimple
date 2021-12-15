package com.qa.springgames.controller;

import java.util.List;

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

import com.qa.springgames.domain.Game;
import com.qa.springgames.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	private GameService service;
	
	private GameController(GameService service) {
		this.service = service;
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Game> createGame(@RequestBody Game t) {
	return new ResponseEntity<Game>(this.service.create(t), HttpStatus.CREATED);	
	}
	
	//Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Game>> readAllGames() {
	return new ResponseEntity<List<Game>>(this.service.getAll(), HttpStatus.OK);	
	}
	
	//Read By Id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Game>readGameById(@PathVariable long id) {
	return new ResponseEntity<Game>(this.service.getById(id), HttpStatus.OK);
	}
		
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable long id, @RequestBody Game t) {
	return new ResponseEntity<Game>(this.service.update(id, t), HttpStatus.ACCEPTED);	
	}
		
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteGame(@PathVariable long id) {
	return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}
