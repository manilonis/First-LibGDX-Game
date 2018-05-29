package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends Game {
	
	//only have one SpriteBatch
	SpriteBatch batch;
	Texture img;
	Sprite player;
	
	@Override
	public void create () {
		System.out.println("Create was Called");
		batch = new SpriteBatch();
		img = new Texture("vine.jpg");
		player = new Sprite(new Texture("firefighter.jpg"));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.setPosition(player.getX() +1 , player.getY());
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(player,player.getX(), player.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
