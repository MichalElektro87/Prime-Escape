package com.prime_escape.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class PlayingGameScreen implements Screen {

    private final PrimeEscape game;
    private Stage stage;
    private Array<NumberActor> numberActors;
    private Score score;
    private EndGameTextActor endGameTextActor;
    private boolean lock = false;
    private int numSteps = 1;
    private int state = 0;
    private int turnCounter = 0;
    private int step = 1;
    private float elapsedTime = 0f;

    public PlayingGameScreen (PrimeEscape game) {
        this.game = game;
    }


    @Override
    public void show() {
        stage = new Stage(new FitViewport(800f, 480f));
        numberActors = new Array<>();
        score = new Score(game);
        endGameTextActor = new EndGameTextActor(game);
        endGameTextActor.setup();
        Gdx.input.setInputProcessor(stage);

        for (int i = 0; i < game.numberCounter; i++) {
            numberActors.add(new NumberActor(game));
            numberActors.get(i).setup();
            numberActors.get(i).setIdNumber(i);
            numberActors.get(i).checkIfPrime();
            numberActors.get(i).getGlyphLayout().setText(game.getDefaultFont(), String.valueOf(numberActors.get(i).getIdNumber()));
            numberActors.get(i).buildInputListener();
            numberActors.get(i).setTouchable(Touchable.enabled);
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

        elapsedTime+=Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        if (game.numberOfPrimes <= 0 && !lock) {
            lock = true;
            game.endGame = true;
            System.out.println("Success!!!");
            for (int i = 0; i < stage.getActors().size; i ++) {
                stage.getActors().get(i).setVisible(false);
            }
            endGameTextActor.setTime(elapsedTime);
            stage.addActor(endGameTextActor);
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

    }
}
