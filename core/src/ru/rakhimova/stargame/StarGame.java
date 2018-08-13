package ru.rakhimova.stargame;
import com.badlogic.gdx.Game;

import ru.rakhimova.stargame.screen.MenuScreen;

public class StarGame extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}