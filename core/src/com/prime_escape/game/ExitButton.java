package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;


public class ExitButton extends Button {

    private final PrimeEscape game;

    public ExitButton (final PrimeEscape game) {
        super(game);
        this.game = game;
        setTouchable(Touchable.enabled);
    }

    @Override
    public void setInputListener() {
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                getScreen().dispose();
                dispose();
                game.dispose();
                Gdx.app.exit();
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



