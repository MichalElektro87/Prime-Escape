package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PlayingGameScreen implements Screen {

    private Stage stage;
    private Array<NumberActor> numberActors;
    private int numSteps = 1;
    private int state = 0;
    private int turnCounter = 0;
    private int step = 1;
    private float xPositionOfField = 800f / 2f;
    private float yPositionOfField = 480f / 2f;
    private float stepSize = 100f;

    @Override
    public void show() {
        stage = new Stage(new FitViewport(800f, 480f));
        numberActors = new Array<>();
        Gdx.input.setInputProcessor(stage);

        for (int i = 0; i < 9; i++) {
            numberActors.add(new NumberActor());
            numberActors.get(i).setup();
            numberActors.get(i).setIdNumber(i);
            numberActors.get(i).setTouchable(Touchable.enabled);
            stage.addActor(numberActors.get(i));
        }

        xPositionOfField = (800f / 2f) - numberActors.get(0).getWidth() / 2;
        yPositionOfField = (480f / 2f) - numberActors.get(0).getHeight() / 2;
        stepSize = numberActors.get(0).getWidth();

        for (int i = 0; i < 9; i ++) {
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
            step++;
            if (step == 10)
                break;
        }
    }



    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

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

    }
}
