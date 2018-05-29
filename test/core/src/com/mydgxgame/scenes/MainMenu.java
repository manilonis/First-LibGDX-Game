/**
 * Michael E Anilonis
 * May 29, 2018
 */
package com.mydgxgame.scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.constants.GameConstants;
import com.mygdx.game.MyGame;
import com.mygdx.players.Cloud;
import com.mygdx.players.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenu implements Screen , ContactListener {
	
	private MyGame game;
	private Texture bg;
	private Player player;
	private Cloud cloud;
	private World world;
	
	private OrthographicCamera camera;
	private Box2DDebugRenderer debugger;
	
	public MainMenu(MyGame g) {
		game = g;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false,GameConstants.width / GameConstants.ratio, GameConstants.height / GameConstants.ratio);
		camera.position.set(GameConstants.width/2f, GameConstants.height/2f,0);
		
		debugger = new Box2DDebugRenderer();
		
		bg = new Texture("vine.jpg");
		
		world = new World(new Vector2(0,-9.8f),true);
		
		world.setContactListener(this);
		
		player = new Player(world,"firefighter.jpg",500,750);
		player.setPosition(0, 0);
		
		cloud = new Cloud(world);
	}
	
	void update(float dt) {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			player.getBody().applyLinearImpulse(new Vector2(-1f,0), player.getBody().getWorldCenter(), true);
		} else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.getBody().applyLinearImpulse(new Vector2(1f,0), player.getBody().getWorldCenter(), true);
		}
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		
		update(delta);
		
		player.updatePlayer();
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.getSpriteBatch().begin();
		game.getSpriteBatch().draw(bg, 0, 0);
		game.getSpriteBatch().draw(player, player.getX() - player.getWidth()/2f, player.getY() - player.getHeight()/2f + 30) ;
		game.getSpriteBatch().draw(cloud, cloud.getX() - cloud.getWidth()/2f, cloud.getY() - player.getHeight()/2f);
		game.getSpriteBatch().end(); 
		
		debugger.render(world, camera.combined);
		
		world.step(Gdx.graphics.getDeltaTime(), 6, 2);
		
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
		bg.dispose();
		player.getTexture().dispose();
		
	}

	@Override
	public void beginContact(Contact contact) {
		System.out.println("Contact");
		
		Fixture playerFix, cloudFix;
		String fixA = (String) contact.getFixtureA().getUserData();
		String fixB = (String) contact.getFixtureB().getUserData();
		
		if(fixA.equals("Player")) {
			playerFix = contact.getFixtureA();
			cloudFix = contact.getFixtureB();
		}
		else {
			playerFix= contact.getFixtureB();
			cloudFix = contact.getFixtureA();
		}
		
		if(fixB.equals("Cloud")) System.out.println("FixB is cloud");
		
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

}
