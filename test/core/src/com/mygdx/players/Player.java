/**
 * Michael E Anilonis
 * May 29, 2018
 */
package com.mygdx.players;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Sprite{
	
	public Player(String image, float x, float y) {
		super(new Texture(image));
		this.setPosition(x, y);
	}
}
