package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mydgxgame.scenes.MainMenu;

public class MyGame extends Game {
	
	//only have one SpriteBatch
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	
	}
	
	public SpriteBatch getSpriteBatch() {
		return batch;
	}
}
