
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

//Actor class for an enemy circle
//No user input

    public class EnemyActor extends Actor {
        //Creating sprite and feeding it our image
        Sprite sprite = new Sprite (new Texture(Gdx.files.internal("enemycircle.png")));
        //default dimensions
        float defaultWidth = 100;
        float defaultHeight = 100;


        public EnemyActor(float xpos, float ypos) {
            //setting starting pos
            sprite.setX(xpos);
            sprite.setY(ypos);


            //Setting dimensions
            setBounds(sprite.getX(), sprite.getY(), defaultWidth, defaultHeight);
            sprite.setSize(defaultWidth, defaultHeight);
            setTouchable(Touchable.enabled);

            //Error checking
            //System.out.println("Enemy Actor Width: "+sprite.getWidth()+ " Height: " +sprite.getHeight());
            //System.out.println("Enemy Actor Scale x: "+sprite.getScaleX()+ " Height: " +sprite.getScaleY());
            //System.out.println("ENEMY START X: " +sprite.getX()+ "Y: "+sprite.getY());
        }
        //Gets the radius of the Actor
        //used for checking if spawning inside each other
        public float getRadius(){

            return sprite.getWidth()/2;

        }
        //Uses Java random num generation to pick a random size for enemy actors
        //
        public void sizeGeneration(){





        }

        @Override
        protected void positionChanged() {
            sprite.setPosition(getX(),getY());
            super.positionChanged();
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {


            sprite.draw(batch);
            //Error checking
            //System.out.println("X: " +sprite.getX()+ "Y: "+sprite.getY());
        }

        @Override
        public void act(float delta) {
            super.act(delta);
        }
    }


