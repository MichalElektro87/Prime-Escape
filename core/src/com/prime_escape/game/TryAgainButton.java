package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class TryAgainButton extends Actor {

    private PrimeEscape game;
    private Stage stage;
    private Pixmap pixmap;
    private ShapeDrawer shapeDrawer;
    private Texture texture;
    private TextureRegion region;
    private String buttonText;
    private GlyphLayout glyphLayout;

    public TryAgainButton (final PrimeEscape game) {
        this.game = game;

        setTouchable(Touchable.enabled);

        pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawPixel(0, 0);
        texture = new Texture(pixmap);
        region = new TextureRegion(texture, 0, 0, 1, 1);
        pixmap.dispose();



        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                game.globalGameTime = 0f;
                game.gameTime = 0f;
                game.score = 0;

                game.setScreen(new PlayingGameScreen(game));
                return true;
            }


            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }

        });
    }

    public void setButtonText () {
        this.buttonText = "Try again...";
        glyphLayout = new GlyphLayout(game.getDefaultFont(), this.buttonText);
        setSize(glyphLayout.width + 60f, game.getDefaultFont().getCapHeight() + 60f);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        game.getDefaultFont().draw(batch, this.buttonText, getX() + 30f, getY() + game.getDefaultFont().getCapHeight() / 2 + getHeight() / 2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
