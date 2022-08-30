package com.prime_escape.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Score extends Actor {

    private final PrimeEscape game;

    public Score (PrimeEscape game) {
        this.game = game;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        game.getDefaultFont().draw(batch, "Score: " + game.score, 680f, 460f);
        game.getDefaultFont().draw(batch, "Primes left: " + game.numberOfPrimes, 680f, 430f);
        game.getDefaultFont().draw(batch, "Level: " + game.levelNumber, 30f, 460f);
        game.getDefaultFont().draw(batch, "Tap the primes!", 30f, 430f);
        game.getDefaultFont().draw(batch, "Create Ulam spiral!", 30f, 400f);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
