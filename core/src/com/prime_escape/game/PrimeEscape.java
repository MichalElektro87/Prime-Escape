package com.prime_escape.game;
import com.badlogic.gdx.Game;

public class PrimeEscape extends Game {

	@Override
	public void create () {
		setScreen(new PlayingGameScreen());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
