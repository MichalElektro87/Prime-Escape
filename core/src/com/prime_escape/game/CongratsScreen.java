package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class CongratsScreen implements Screen {

    private final PrimeEscape game;
    private Stage stage;
    private EndGameTextActor endGameTextActor;

    public CongratsScreen (PrimeEscape game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new StretchViewport(800f, 480f));
        endGameTextActor = new EndGameTextActor(game);
        endGameTextActor.setTime(game.gameTime);
        stage.addActor(endGameTextActor);
        game.endGame = false;
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        if (Gdx.input.justTouched()) {
            this.dispose();
            game.setScreen(new PlayingGameScreen(game));
        }

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
