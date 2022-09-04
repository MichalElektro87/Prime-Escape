package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class EndLevelScreen implements Screen {

    private final PrimeEscape game;
    private Stage stage;
    private LevelButton levelButton;
    private ExitButton exitButton;
    private EndLevelTextActor endLevelTextActor;
    private String endLevelText [];

    public EndLevelScreen(final PrimeEscape game) {
        this.game = game;
    }

    @Override
    public void show() {
        game.levelNumber++;
        stage = new Stage(new FitViewport(800f, 480f));

        levelButton = new LevelButton(game);
        levelButton.setScreen(this);
        levelButton.setInputListener();
        levelButton.setButtonText("Level " + game.levelNumber);
        levelButton.setGlyphLayout();
        levelButton.setSizeAndBounds();
        levelButton.setPosition((800f * 1/4) - levelButton.getWidth() / 2, 200f - levelButton.getHeight() / 2);

        exitButton = new ExitButton(game);
        exitButton.setScreen(this);
        exitButton.setInputListener();
        exitButton.setButtonText("Exit");
        exitButton.setGlyphLayout();
        exitButton.setSizeAndBounds();
        exitButton.setPosition((800f * 3/4)- exitButton.getWidth() / 2, 200f - exitButton.getHeight() / 2);

        endLevelTextActor = new EndLevelTextActor(game);
        endLevelText = new String[2];
        endLevelText[0] = "Yes! You have found all primes on stage!";
        endLevelText[1] = "Your time is: " + Math.round(game.gameLevelTime) + " s and score: " + game.score + ". I know you can do better!";
        endLevelTextActor.setText(endLevelText);

        stage.addActor(levelButton);
        stage.addActor(exitButton);
        stage.addActor(endLevelTextActor);

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
        stage.getViewport().update(width, height);
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
        stage.dispose();
    }
}
