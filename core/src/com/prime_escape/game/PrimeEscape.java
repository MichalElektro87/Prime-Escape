package com.prime_escape.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PrimeEscape extends Game {

	private BitmapFont defaultFont;
	private int primeCounter = 0;

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

	public void increasePrimeCounter () {
		primeCounter++;
	}

	public void decreasePrimeCounter () {
		primeCounter--;
	}

	public int getPrimeCounter () {
		return primeCounter;
	}

	@Override
	public void dispose () {
	}
}
