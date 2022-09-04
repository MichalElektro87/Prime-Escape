package com.prime_escape.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class LevelButton extends Button {

    private final PrimeEscape game;

    public LevelButton (final PrimeEscape game) {
        super(game);
        this.game = game;
    }


    @Override
    public void setInputListener() {
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.getClickSound().play();
                dispose();
                getScreen().dispose();
                game.setScreen(new PlayingGameScreen(game));
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
