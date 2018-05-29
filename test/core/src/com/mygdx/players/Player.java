/**
 * Michael E Anilonis
 * May 29, 2018
 */
package com.mygdx.players;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Sprite{
	
	private World world;
	private Body body;
	
	public Player(World w, String image, float x, float y) {
		super(new Texture(image));
		this.setPosition(x, y);
		world = w;
		createBody();
	}
	
	void createBody() {
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyDef.BodyType.DynamicBody;
		bodydef.position.set(getX(),getY());
		
		body = world.createBody(bodydef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(getWidth()/2f, getHeight()/2f);
		
		FixtureDef fixturedef = new FixtureDef();
		fixturedef.shape = shape;
		fixturedef.density = 1;
		
		Fixture fixture = body.createFixture(fixturedef);
		
		shape.dispose();
	}
	
	public void updatePlayer() {
		this.setPosition(body.getPosition().x, body.getPosition().y);
	}
}
