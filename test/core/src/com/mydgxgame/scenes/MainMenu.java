/**
 * Michael E Anilonis
 * May 29, 2018
 */
package com.mydgxgame.scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MainMenu implements Screen {
	
	private MyGame game;
	private Texture bg;
	private Sprite player;
	
	public MainMenu(MyGame g) {
		game = g;
		
		bg = new Texture("vine.jpg");
		player = new Sprite(new Texture("firefighter.jpg"));
		player.setPosition(0, 0);
	}

	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.getSpriteBatch().begin();
		game.getSpriteBatch().draw(bg, 0, 0);
		game.getSpriteBatch().draw(player, player.getX()+1, player.getY());
		game.getSpriteBatch().end(); 
		
	}

	@Override
	public void resize(int width, int height) {
	
		
	}

	@Override
	public void pause() {
	
		
	}

	@Override
	public void resume() {
	
		
	}

	@Override
	public void hide() {
	
		
	}

	@Override
	public void dispose() {
		
		
	}

}
