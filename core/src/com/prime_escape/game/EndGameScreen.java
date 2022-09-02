package com.prime_escape.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class EndGameScreen implements Screen {

    private PrimeEscape game;
    private Stage stage;
    private TryAgainButton tryAgainButton;
    private String endGameText = "";
    private String endGameText2 = "";
    private GlyphLayout glyphLayout;

    public  EndGameScreen (PrimeEscape game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new StretchViewport(800f, 480f));
        tryAgainButton = new TryAgainButton(game);
        tryAgainButton.setPosition((800f * 1/4) - tryAgainButton.getWidth() / 2, 200f - tryAgainButton.getHeight() / 2);
        stage.addActor(tryAgainButton);
        endGameText = "Great! You have finish the game!";
        endGameText2 = "Your game time is: " + game.globalGameTime + " and score: " + game.score;
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
