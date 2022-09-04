package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Disposable;

public abstract class Button extends Actor implements Disposable {

    private final PrimeEscape game;
    private Screen screen;
    private String buttonText;
    private GlyphLayout glyphLayout;
    private Texture texture;
    private TextureRegion textureRegion;

    public Button (final PrimeEscape game) {
        this.game = game;
        texture = new Texture(Gdx.files.internal("button.png"));
        textureRegion = new TextureRegion(texture);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setTouchable(Touchable.enabled);
    }

    public abstract void setInputListener ();

    public void setScreen (Screen screen) {
        this.screen = screen;
    }

    public void setButtonText (String buttonText) {
        this.buttonText = buttonText;
    }

    public void setGlyphLayout () {
        glyphLayout = new GlyphLayout(game.getDefaultFont(), this.buttonText);
    }

    public void setSizeAndBounds () {
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public Screen getScreen () {
        return this.screen;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        game.getDefaultFont().draw(batch, this.buttonText, getX() + getWidth() / 2 - glyphLayout.width / 2, getY() + getHeight() / 2 - glyphLayout.height / 2 + game.getDefaultFont().getCapHeight());
    }

    @Override
    public void dispose() {

    }
}
