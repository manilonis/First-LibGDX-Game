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
import com.mygdx.constants.GameConstants;


public class Cloud extends Sprite {
	
	private World world;
	private Body body;
	
	public Cloud(World w) {
		super(new Texture("cloud.jpg"));
		world = w;
		this.setPosition(500, 100);
		createBody();
	}
	
	void createBody() {
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyDef.BodyType.StaticBody;
		bodydef.position.set(getX() / GameConstants.ratio ,getY() / GameConstants.ratio);
		
		body = world.createBody(bodydef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox((getWidth()/2f)/GameConstants.ratio, (getHeight()/2f)/GameConstants.ratio);
		
		FixtureDef fixturedef = new FixtureDef();
		fixturedef.shape = shape;
		fixturedef.density = 1;
		
		Fixture fixture = body.createFixture(fixturedef);
		fixture.setUserData("Cloud");
		//fixture.setSensor(true);
		
		shape.dispose();
	}
	
}
