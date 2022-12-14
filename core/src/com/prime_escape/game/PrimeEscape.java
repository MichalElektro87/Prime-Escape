package com.prime_escape.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class PrimeEscape extends Game {

	private BitmapFont defaultFont;
	private Sound clickSound;
	private Sound wrongNumberSound;
	public boolean endGame = false;
	public int numberCounter = 90;
	public int score = 0;
	public int numberOfPrimes = 0;
	public int levelNumber = 1;
	public int startingNumber = 9;
	public float gameLevelTime = 0f;
	public float globalGameTime = 0f;

	@Override
	public void create () {
		defaultFont = new BitmapFont(Gdx.files.internal("gameFont15.fnt"));
		clickSound = Gdx.audio.newSound(Gdx.files.internal("menu_button_click.wav"));
		wrongNumberSound = Gdx.audio.newSound(Gdx.files.internal("wrong_number.wav"));
		setScreen(new PlayingGameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public BitmapFont getDefaultFont () {
		return defaultFont;
	}
	public Sound getClickSound () {
		return clickSound;
	}

	public Sound getWrongNumberSound () {
		return wrongNumberSound;
	}

	public void resetGameToDefaults () {
		endGame = false;
		numberCounter = 90;
		score = 0;
		numberOfPrimes = 0;
		levelNumber = 1;
		startingNumber = 9;
		gameLevelTime = 0f;
		globalGameTime = 0f;
	}

	@Override
	public void dispose () {
		defaultFont.dispose();
		clickSound.dispose();
		wrongNumberSound.dispose();
	}
}
