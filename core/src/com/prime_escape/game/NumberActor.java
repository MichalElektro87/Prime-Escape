package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class NumberActor extends Actor {

    private final PrimeEscape game;
    private Texture texture;
    private TextureRegion textureRegion;
    private Rectangle rectangle;
    private int idNumber = 0;
    private boolean prime = true;

    public NumberActor (PrimeEscape game) {
        this.game = game;
    }

    public void setup () {
        texture = new Texture(Gdx.files.internal("field.png"));
        textureRegion = new TextureRegion(texture);
        rectangle = new Rectangle();
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        rectangle.setSize(getWidth(), getHeight());
    }

    public void buildInputListener () {
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                if (!game.endGame) {
                    if (isVisible()) {
                        if (isPrime()) {
                            setVisible(false);
                            game.score++;
                            game.numberOfPrimes--;
                        } else {
                            game.score--;
                        }
                    }
                    System.out.println(game.numberOfPrimes);
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
        game.getDefaultFont().draw(batch, ""+ idNumber, getX() + getWidth() / 2f, getY() + getHeight() / 2f);

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

}
