package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Disposable;

public class NumberActor extends Actor implements Disposable {

    private final PrimeEscape game;
    private Texture texture;
    private TextureRegion textureRegion;
    private GlyphLayout glyphLayout;
    private int idNumber = 0;
    private boolean prime = true;

    public NumberActor (final PrimeEscape game) {
        this.game = game;
    }

    public void setup () {
        texture = new Texture(Gdx.files.internal("field.png"));
        textureRegion = new TextureRegion(texture);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        glyphLayout = new GlyphLayout();
    }

    public void buildInputListener () {
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    if (isVisible()) {
                        if (isPrime()) {
                            game.getClickSound().play();
                            setVisible(false);
                            game.score++;
                            game.numberOfPrimes--;
                        } else {
                            game.getWrongNumberSound().play();
                            game.score--;
                        }
                    }
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        game.getDefaultFont().draw(batch, ""+ idNumber, getX() + getWidth() / 2f - getGlyphLayout().width / 2, getY() + getHeight() / 2f - getGlyphLayout().height / 2 + game.getDefaultFont().getCapHeight());

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public void setIdNumber (int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIdNumber () {
        return idNumber;
    }

    public void checkIfPrime () {

        if (idNumber == 0 || idNumber == 1) {
            this.prime = false;
            return;
        }

        for (int i = 2; i <= Math.sqrt(this.idNumber); i ++) {
            if (this.idNumber % i == 0) {
                this.prime = false;
                break;
            }
        }
    }

    public boolean isPrime () {
        return this.prime;
    }

    public GlyphLayout getGlyphLayout () {
        return glyphLayout;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
