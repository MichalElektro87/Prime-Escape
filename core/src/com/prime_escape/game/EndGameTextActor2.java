package com.prime_escape.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class EndGameTextActor2 extends Actor {

    private final PrimeEscape game;

    public EndGameTextActor2 (PrimeEscape game) {
        this.game = game;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.getDefaultFont().draw(batch, "Yuuupi!! You have found all primes!\n\n" +
                "Your score is: " + game.score + " and time: "+ Math.round(game.gameTime) +" s. I know you can do better!!!" , 200f, 300f + game.getDefaultFont().getLineHeight() ,400f ,1 ,true);

    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

