package ru.rakhimova.stargame.screen.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.rakhimova.stargame.base.Sprite;
import ru.rakhimova.stargame.math.Rect;

public class MainShip extends Sprite {

    private final float STEP = 0.005f;
    private Vector2 v = new Vector2(0, 0);
    private Vector2 vDelta = new Vector2(0, 0);
    private Rect worldBounds;
    private TextureRegion region;

    public MainShip(TextureAtlas atlas) {
        regions = new TextureRegion[1];
        region = atlas.findRegion("main_ship");
        regions[0] = new TextureRegion(region,0,0,region.getRegionWidth()/2, region.getRegionHeight());
        setHeightProportion(0.2f);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame], // текущий регион
                getLeft(), worldBounds.getBottom(), // точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по оси x и y
                angle // угол вращения
        );
        pos.add(vDelta);
    }

    @Override
    public void update(float delta) {
        pos.add(vDelta);
        checkAndHandleBounds();
    }

    protected void checkAndHandleBounds() {
        if (getRight() > worldBounds.getRight()) vDelta.set(0, 0);
        if (getLeft() < worldBounds.getLeft()) vDelta.set(0, 0);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        pos.add(vDelta);
    }

    public void changePosition(float i) {
        float step = STEP * i;
        v.set(pos.x + step, 0);
        vDelta = v.sub(pos);
    }
}
