package ru.rakhimova.stargame.screen.menuscreen;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.rakhimova.stargame.base.ActionListener;
import ru.rakhimova.stargame.base.ScaledTouchUpButton;
import ru.rakhimova.stargame.math.Rect;

public class ButtomNewGame extends ScaledTouchUpButton {

    public ButtomNewGame(TextureAtlas atlas, ActionListener actionListener, float pressScale, String nameRegion) {
        super(atlas.findRegion(nameRegion), actionListener, pressScale);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setLeft(worldBounds.getLeft());
    }
}
