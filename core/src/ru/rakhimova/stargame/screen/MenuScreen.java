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
    SpriteBatch batch;
    Texture img;

    Vector2 pos;
    Vector2 v;
    Vector2 v1;

    Vector2 touchPos;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("mario.png");
        pos = new Vector2(0, 0);
        v = new Vector2();
        touchPos = new Vector2();
        v1 = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        while(pos.x <= touchPos.x && pos.y <= touchPos.y) {
            batch.draw(img, pos.x, pos.y);
        }
        batch.end();
        pos.add(v1);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touchPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        v1 = touchPos.sub(v);
        v1.nor();
        System.out.println("touchPos.x = " + touchPos.x + " touchPos.y = " + touchPos.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        return false;
    }
}
