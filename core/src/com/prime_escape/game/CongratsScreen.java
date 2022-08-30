package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class CongratsScreen implements Screen {

    private final PrimeEscape game;
    private Stage stage;
    private EndGameTextActor endGameTextActor;
    private LevelButton levelButton;
    private ExitButton exitButton;
    private Table table;

    public CongratsScreen (PrimeEscape game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.levelNumber++;
        stage = new Stage(new StretchViewport(800f, 480f));
        table = new Table();
        endGameTextActor = new EndGameTextActor(game);
        levelButton = new LevelButton(game);
        levelButton.setStage(stage);
        levelButton.setButtonText();
        levelButton.setPosition((800f * 1/4) - levelButton.getWidth() / 2, 200f - levelButton.getHeight() / 2);
        exitButton = new ExitButton(game);
        exitButton.setStage(stage);
        exitButton.setButtonText();
        exitButton.setPosition((800f * 3/4)- exitButton.getWidth() / 2, 200f - exitButton.getHeight() / 2);
        endGameTextActor.setTime(game.gameTime);

        game.endGame = false;
        stage.addActor(endGameTextActor);
        stage.addActor(levelButton);
        stage.addActor(exitButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();


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