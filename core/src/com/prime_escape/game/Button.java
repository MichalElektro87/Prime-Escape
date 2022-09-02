package com.prime_escape.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Disposable;

import space.earlygrey.shapedrawer.ShapeDrawer;

public abstract class Button extends Actor implements Disposable {

    private PrimeEscape game;
    private Screen screen;
    private Stage stage;
    private Pixmap pixmap;
    private ShapeDrawer shapeDrawer;
    private Texture texture;
    private TextureRegion region;
    private String buttonText;
    private GlyphLayout glyphLayout;

    public Button (PrimeEscape game) {
        this.game = game;
        setTouchable(Touchable.enabled);
    }

    public abstract void setInputListener ();

    public void setStage (Stage stage) {
        this.stage = stage;
    }

    public void setupShapeDrawer () {
        pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawPixel(0, 0);
        texture = new Texture(pixmap);
        region = new TextureRegion(texture, 0, 0, 1, 1);
        pixmap.dispose();
        shapeDrawer = new ShapeDrawer(stage.getBatch(), region);
    }

    public void setButtonText (String buttonText) {
        this.buttonText = buttonText;
    }

    public void setGlyphLayout () {
        glyphLayout = new GlyphLayout(game.getDefaultFont(), this.buttonText);
    }

    public void setSizeAndBounds () {
        setSize(glyphLayout.width + 60f, game.getDefaultFont().getCapHeight() + 60f);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    public Screen getScreen () {
        return this.screen;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        shapeDrawer.rectangle(getX(), getY(), getWidth(), getHeight(), 2f);
        game.getDefaultFont().draw(batch, this.buttonText, getX() + 30f, getY() + game.getDefaultFont().getCapHeight() / 2 + getHeight() / 2);
    }

    public ShapeDrawer getShapeDrawer () {
        return shapeDrawer;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
