package com.prime_escape.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class PrimeEscape extends Game {

	private BitmapFont defaultFont;
	public boolean endGame = false;
	public int numberCounter = 5;
	public int score = 0;
	public int numberOfPrimes = 0;

	@Override
	public void create () {
		defaultFont = new BitmapFont();
		setScreen(new PlayingGameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public BitmapFont getDefaultFont () {
		return defaultFont;
	}


	@Override
	public void dispose () {
	}
}
