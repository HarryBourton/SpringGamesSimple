package com.qa.springgames.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.springgames.domain.Game;
import com.qa.springgames.repo.GameRepo;

@Service
public class GameService implements ServiceMethods<Game> {
	private GameRepo repo;

	public GameService(GameRepo repo) {
		this.repo = repo;
	}

	@Override
	public Game create(Game t) {
		return this.repo.save(t);
	}

	@Override
	public List<Game> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Game getById(long id) {
		Optional<Game> optionalGame = this.repo.findById(id);
		if (optionalGame.isPresent()) {
			return optionalGame.get();
		}
		return null;
	}

	@Override
	public Game update(long id, Game t) {
		Optional<Game> existingGame = this.repo.findById(id);
		if (existingGame.isPresent()) {
			Game existing = existingGame.get();
			existing.setReleaseYear(t.getReleaseYear());
			existing.setGenre(t.getGenre());
			existing.setName(t.getName());

			return this.repo.saveAndFlush(existing);
		}

		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
