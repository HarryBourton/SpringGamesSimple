package com.qa.springgames.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springgames.domain.Game;

public interface GameRepo extends JpaRepository<Game, Long> {

}
