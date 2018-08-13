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
    Vector2 v2;

    Vector2 touchPos;

    float lengthV1;
    float step;

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
        v1 = new Vector2(0,0);
        v2 = v1.cpy();
        step = 50;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //if(pos.len2() != lengthV1) {
            batch.draw(img, v2.x, v2.y);
       // }
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
    public boolean keyDown(int keycode) {
      switch (keycode){
          case (19):
              v2.add(0,step);
              break;
          case (20):
              v2.add(0,-step);
              break;
          case (21):
              v2.add(-step,0);break;
          case (22):
              v2.add(step,0);
              break;
      }

        return super.keyDown(keycode);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;
        System.out.println("touchDown screenX = " + screenX + " screenY = " + screenY);
        touchPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        v1 = touchPos.sub(v);
        lengthV1 = v1.len2();
        v1.scl(0.05f);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
       // super.touchUp(screenX, screenY, pointer, button);
        return false;
    }
}
