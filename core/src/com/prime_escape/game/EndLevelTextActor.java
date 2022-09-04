package com.prime_escape.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class EndLevelTextActor extends Actor {

    private final PrimeEscape game;
    private String [] text = {null,null};

    public EndLevelTextActor(final PrimeEscape game) {
        this.game = game;
    }

    public void setText (String [] text) {
        this.text[0] = text [0];
        this.text[1] = text [1];
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.getDefaultFont().draw(batch, text[0], 200f, 350f + game.getDefaultFont().getLineHeight() ,400f ,1 ,true);
        game.getDefaultFont().draw(batch, text[1] , 200f, 320f + game.getDefaultFont().getLineHeight() ,400f ,1 ,true);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
