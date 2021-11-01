package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.Random;

//test

public class ActorDemo extends ApplicationAdapter {

	Stage stage;

	private BackgroundActor background;
	private EnemyActor enemyActor;
	private MyActor playerActor;
	private Collision collision;
	//For random num generation for enemy numbers and x,y locations
	Random random = new Random();
	/**Creates an array list of enemy actors so retrieving x and y is easier.
	//Can't be done through stage*/
	static ArrayList<EnemyActor> enemyList = new ArrayList();

	//our screen res, used to limit enemy positions
	final int screenX = 1024;
	final int screenY = 768;


	@Override
	public void create () {

		ScreenViewport viewport = new ScreenViewport();
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);
		enemyList = new ArrayList();


		/**Makes new object from the background class
		//Just a jpg with a blue gradient
		//Must be called first or it will be drawn ontop of all other actors*/
		this.background = new BackgroundActor();
		stage.addActor(background);
		background.setName("background");

		/**Setting amount of random enemies
		//Can't be more than 6 or less than 2*/
		int ranEnemy = random.nextInt(15-10) + 10;
		int bigEnemy = ranEnemy / 3;
		int medEnemy = ranEnemy / 3;
		int smallEnemy = ranEnemy / 3;

		//Declaring variables random x and y for enemy pos and the 3 random sizes
		float xRan;
		float yRan;
		float sizeBig;
		float sizeMed;
		float sizeSmall;

		/**RANDOM ENEMY GENERATION starts here
		//**************************************/
		//First make a new collision object for checking enemy collision
		Collision enemyCollide = new Collision();
		//This first for loop is for creating enemies while we're below the # of enemies we're going to make
		for (int i = 0; i < ranEnemy; i++) {

			//Setting x and y location of enemy we'll be creating taking into
			xRan = random.nextInt((950 - 100) + 1 ) + 100;
			yRan = random.nextInt((700 - 100) + 1 ) + 100;
			//create size parameters

			sizeBig = random.nextInt((150 - 149) + 1) + 149;
			sizeMed = random.nextInt((75 - 74) + 1) + 74;
			sizeSmall = random.nextInt((25 - 10) + 1) + 10;


			//Makes new enemy actor, gives it our random x and y, and passes it to the stage
			if (i < bigEnemy){
				this.enemyActor = new EnemyActor(xRan, yRan, sizeBig);
			}else if ( i < medEnemy * 2){

				//we're make a medium one
				this.enemyActor = new EnemyActor(xRan, yRan, sizeMed);
			}else{

				//we're make a small one
				this.enemyActor = new EnemyActor(xRan, yRan, sizeSmall);
			}
			enemyList.add(this.enemyActor);//adds new actor to array list
			stage.addActor(enemyActor);
			//ERROR CHECKING:
			enemyActor.setName("enemyActor");
			System.out.println("The enemy" + i + " is at x: " + enemyList.get(i).getX() + " Y: "+ enemyList.get(i).getY());
			//is used in for loop below
			int f = 0;
			//If we're not on the first enemy, then continue to for loop
			if (i != 0) {
				/**This for loop goes through the array, checking collisions of newly created enemy x,y against the old
				// "f" is # of old enemy in array. "i" is newest enemy. For loop is limited by i to keep us counting
				//past higher than # of enemies in array. j and f both count us through the array*/
				for (int j = 0; j < i; j++) {
					//makes our circles for collision testing, new enemy and old
					enemyCollide.setCircles(enemyList.get(i), enemyList.get(f));
					//Error checking
					System.out.println("Checking enemy"+i+" against enemy"+f);

					/**If our collision returns true, set new x,y values for our new enemy and reset j and f so we can
					// restart our check through the array*/
					if (enemyCollide.isCollide()) {

						enemyList.get(i).setX(random.nextInt(700-100) +100);
						enemyList.get(i).setY(random.nextInt(700-100) +100);
						//Error checking
						System.out.println("collision with enemy"+f);
						System.out.println("Moved enemy" + i+ " to x: "+ enemyList.get(i).getX() + " Y: "+ enemyList.get(i).getY());
						//restarts loop, sets them to -1 due to adding 1 at end of loop
						j = -1;
						f = -1;
					}
					//this makes us count up in the array
					f++;

				}

			}
		}
		System.out.println("Enemy creation complete!");


		//Location of enemy actor in array:
		//System.out.println("This actor name: "+stage.getActors().get(1).getName()+ "\n");

		//Makes new object from player actor and passes it to stage
		this.playerActor = new MyActor();
		stage.addActor(playerActor);
		//sets actor name, only for testing
		playerActor.setName("playerActor");
		//passes keyboard events to player actor
		stage.setKeyboardFocus(playerActor);


	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		stage.act(Gdx.graphics.getDeltaTime());

		//Collision detection starts here
		//
		this.collision = new Collision();
		collision.setCircles(playerActor, enemyActor);
		collision.isCollide();


		stage.draw();


	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}


	private class random {
	}
}

