package ru.rakhimova.stargame;
import com.badlogic.gdx.Game;

import ru.rakhimova.stargame.screen.MenuScreen;

public class Star2DGame extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}