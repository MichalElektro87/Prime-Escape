package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.DelayedRemovalArray;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class ExitButton extends Button {

    private PrimeEscape game;
    private Screen screen;

    public ExitButton (final PrimeEscape game) {
        super(game);
        this.game = game;
        setTouchable(Touchable.enabled);
    }

    @Override
    public void setInputListener() {
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
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



