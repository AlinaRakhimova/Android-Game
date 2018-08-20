package ru.rakhimova.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.rakhimova.stargame.base.Base2DScreen;
import ru.rakhimova.stargame.math.Rect;
import ru.rakhimova.stargame.screen.sprites.Background;
import ru.rakhimova.stargame.screen.sprites.MainShip;
import ru.rakhimova.stargame.screen.sprites.Star;


public class GameScreen extends Base2DScreen {

    private static final int STAR_COUNT = 20;
    private Background background;
    private Texture bgTexture;
    private TextureAtlas menuAtlas;
    private Star star[];
    private MainShip mainShip;
    private TextureAtlas mainAtlas;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        bgTexture = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bgTexture));
        menuAtlas = new TextureAtlas("textures/menuAtlas.tpack");
        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(menuAtlas);
        }
        background = new Background(new TextureRegion(bgTexture));
        mainAtlas = new TextureAtlas("textures/mainAtlas.tpack");
        mainShip = new MainShip(mainAtlas);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        checkCollisions();
        deleteAllDestroyed();
        draw();
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        mainShip.draw(batch);
        batch.end();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
        mainShip.update(delta);
    }

    public void checkCollisions() {

    }

    public void deleteAllDestroyed() {

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
        mainShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bgTexture.dispose();
        menuAtlas.dispose();
        mainAtlas.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case (Input.Keys.LEFT):
                mainShip.changePosition(-1);
                break;
            case (Input.Keys.RIGHT):
                mainShip.changePosition(1);
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        switch (character) {
            case ('a'):
                mainShip.changePosition(-1);
                break;
            case ('d'):
                mainShip.changePosition(1);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case (Input.Keys.LEFT):
                mainShip.changePosition(0);
                break;
            case (Input.Keys.RIGHT):
                mainShip.changePosition(0);
                break;
        }
        
        return false;
    }
}

