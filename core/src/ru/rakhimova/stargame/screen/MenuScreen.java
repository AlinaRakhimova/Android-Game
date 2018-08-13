package ru.rakhimova.stargame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.rakhimova.stargame.base.Base2DScreen;

/**
 * Экран меню
 */

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture img;
    private Vector2 position;
    private Vector2 v;
    private Vector2 touchPos;
    private int x;
    private int y;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("mario.png");
        position = new Vector2(0, 0);
        touchPos = new Vector2();
        v = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, position.x, position.y);
        if ((position.x < x) && (position.y < y)) {
            position.add(v);
        }
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        float step = 50;
        switch (keycode) {
            case (19):
                position.add(0, step);
                break;
            case (20):
                position.add(0, -step);
                break;
            case (21):
                position.add(-step, 0);
                break;
            case (22):
                position.add(step, 0);
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;
        y = screenY;
        x = screenX;
        touchPos.set(screenX, screenY);
        v = touchPos.sub(position);
        v.scl(0.005f);
        return false;
    }

}
