package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class EndGameScreen implements Screen {

    private final PrimeEscape game;
    private Stage stage;
    private NewGameButton newGameButton;
    private ExitButton exitButton;
    private EndGameTextActor endGameTextActor;
    private String endGameText [];

    public EndGameScreen (final PrimeEscape game) {
        this.game = game;
        stage = new Stage(new FitViewport(800f, 480f));

        newGameButton = new NewGameButton(game);
        newGameButton.setScreen(this);
        newGameButton.setInputListener();
        newGameButton.setButtonText("New game");
        newGameButton.setGlyphLayout();
        newGameButton.setSizeAndBounds();
        newGameButton.setPosition((800f * 1/4) - newGameButton.getWidth() / 2, 200f - newGameButton.getHeight() / 2);

        exitButton = new ExitButton(game);
        exitButton.setScreen(this);
        exitButton.setInputListener();
        exitButton.setButtonText("Exit");
        exitButton.setGlyphLayout();
        exitButton.setSizeAndBounds();
        exitButton.setPosition((800f * 3/4)- exitButton.getWidth() / 2, 200f - exitButton.getHeight() / 2);

        endGameTextActor = new EndGameTextActor(game);
        endGameText = new String[2];
        endGameText[0] = "Congratulations! You have finished the game!";
        endGameText[1] = "Your time is: " + Math.round(game.globalGameTime) + " s and score: " + game.score;
        endGameTextActor.setText(endGameText);

        stage.addActor(newGameButton);
        stage.addActor(exitButton);
        stage.addActor(endGameTextActor);

        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

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
