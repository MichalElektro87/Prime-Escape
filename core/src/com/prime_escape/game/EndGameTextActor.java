package com.prime_escape.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class EndGameTextActor extends Actor {

    private final PrimeEscape game;
    private GlyphLayout glyphLayout;
    private float time = 0f;

    public EndGameTextActor (PrimeEscape game) {
        this.game = game;
    }

    public void setup () {
        glyphLayout = new GlyphLayout();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.getDefaultFont().draw(batch, "Yuuupi!! You have found all primes!\n\n" +
                "Your score is: " + game.score + " and time: "+ Math.round(game.gameTime) +" s. I know you can do better!!!" , 200f, 240f + game.getDefaultFont().getLineHeight() ,400f ,1 ,true);

    }

    public void setTime (float time) {
        this.time = time;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
