package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class PlayingGameScreen implements Screen {

    private final PrimeEscape game;
    private Stage stage;
    private Array<NumberActor> numberActors;
    private Score score;
    private boolean lockEndLevelStatement = false;
    private boolean lockEndGameStatement = false;
    private int numSteps = 1;
    private int state = 0;
    private int turnCounter = 0;
    private int step = 1;

    public PlayingGameScreen (final PrimeEscape game) {
        this.game = game;
    }


    @Override
    public void show() {

        game.gameLevelTime = 0f;

        if (game.levelNumber == 1) {
            game.numberCounter = 9;
            game.startingNumber = 0;
        }

        else if (game.levelNumber == 2) {
            game.numberCounter = 25;
            game.startingNumber = 0;
        }

        else if (game.levelNumber == 3) {
            game.numberCounter = 56;
            game.startingNumber = 0;
        }

        else if (game.levelNumber == 4) {
            game.numberCounter = 90;
            game.startingNumber = 0;
        }

        else if (game.levelNumber == 5) {
            game.numberCounter = 90;
            game.startingNumber = 90;
        }

        else {
            game.numberCounter = 90;
            game.startingNumber *= 2;
        }

        stage = new Stage(new FitViewport(800f, 480f));
        numberActors = new Array<>();
        score = new Score(game);
        Gdx.input.setInputProcessor(stage);

        for (int i = 0; i < game.numberCounter; i++) {
            numberActors.add(new NumberActor(game));
            numberActors.get(i).setup();
            numberActors.get(i).setIdNumber(i + game.startingNumber);
            if (numberActors.get(i).getIdNumber() > 1000) {
               game.endGame = true;
            }
            numberActors.get(i).checkIfPrime();
            numberActors.get(i).getGlyphLayout().setText(game.getDefaultFont(), String.valueOf(numberActors.get(i).getIdNumber()));
            numberActors.get(i).buildInputListener();
            numberActors.get(i).setTouchable(Touchable.enabled);
            numberActors.get(i).setVisible(true);
            stage.addActor(numberActors.get(i));
            stage.addActor(score);
            if (numberActors.get(i).isPrime()) {
                game.numberOfPrimes++;
            }
        }

        distributeActorsInUlamSpiralOrder();

    }

    public void distributeActorsInUlamSpiralOrder () {
        float xPositionOfField = (800f / 2f) - numberActors.get(0).getWidth() / 2;
        float yPositionOfField = (480f / 2f) - numberActors.get(0).getHeight() / 2;
        float stepSize = numberActors.get(0).getWidth();

        for (int i = 0; i < numberActors.size; i ++) {
            numberActors.get(i).setPosition(xPositionOfField, yPositionOfField);
            switch (state) {
                case 0:
                    xPositionOfField += stepSize;
                    break;
                case 1:
                    yPositionOfField += stepSize;
                    break;
                case 2:
                    xPositionOfField -= stepSize;
                    break;
                case 3:
                    yPositionOfField -= stepSize;
                    break;
            }

            if (step % numSteps == 0) {
                state = (state + 1) % 4;
                turnCounter++;
                if (turnCounter % 2 == 0) {
                    numSteps++;
                }
            }

            if (step == numberActors.size)
                break;

            step++;
        }
    }

    @Override
    public void render(float delta) {

        game.globalGameTime+=Gdx.graphics.getDeltaTime();
        game.gameLevelTime+=Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0f, 0f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();


        if (game.endGame && !lockEndGameStatement) {
            lockEndGameStatement = true;
            this.dispose();
            game.setScreen(new EndGameScreen(game));
        }

        if (game.numberOfPrimes <= 0 && !lockEndLevelStatement) {
            lockEndLevelStatement = true;
            for (int i = 0; i < numberActors.size; i ++) {
                numberActors.get(i).setVisible(false);
            }
            this.dispose();
            game.setScreen(new EndLevelScreen(game));
        }

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

        for (int i = 0; i < numberActors.size; i++) {
            numberActors.get(i).dispose();
        }
    }
}
