package ru.rakhimova.stargame.screen.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.rakhimova.stargame.base.SpritesPool;
import ru.rakhimova.stargame.screen.gamescreen.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private TextureRegion region;
    private Sound sound;

    public ExplosionPool(TextureAtlas atlas, Sound sound) {
        region = atlas.findRegion("explosion");
        this.sound = sound;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(region, 9, 9,74, sound);
    }
}
