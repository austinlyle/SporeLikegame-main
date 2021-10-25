package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

//
//Actor Class for the players Circle, takes users input

public class MyActor extends Actor {

    //The default starting dimensions for our object
    private float defaultWidth = 100;
    private float defaultHeight= 100;

    //Creating the sprite, feeding it the image
    Sprite sprite = new Sprite (new Texture(Gdx.files.internal("playercircle.png")));

    //Booleans for movement
    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;

    //X and Y positions of the actor
    float x;
    float y;

    public MyActor() {

        //Sets sprites x,y, width height.
        //Then sets the size it will be drawn at
        setBounds(sprite.getX(), sprite.getY(), defaultWidth, defaultHeight);
        sprite.setSize(defaultWidth,defaultHeight);
        setTouchable(Touchable.enabled);

        //ERROR CHECKING:
        System.out.println("Actor Width: "+sprite.getWidth()+ " Height: "+sprite.getHeight());
        System.out.println("ACTOR START X: " +sprite.getX()+ "Y: "+sprite.getY());


        //Input starts here
        //
        //This section is for keydown, uses an event based method.
        //If a key has been pressed, sets move to true. While move is true, movement will occur in draw.
        //Tried using Scene2D MoveByAction but could not get holding down keys to work.
        addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {

                if (keycode == Input.Keys.RIGHT) {
                    moveRight = true;
                }
                if (keycode == Input.Keys.LEFT) {
                    moveLeft = true;
                }
                if (keycode == Input.Keys.UP) {
                    moveUp = true;
                }
                if (keycode == Input.Keys.DOWN) {
                    moveDown = true;
                }

                return false;
            }
            //Input monitoring for keyup/key being released
            //will return false stopping input
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.RIGHT) {
                    moveRight = false;
                }
                if (keycode == Input.Keys.LEFT) {
                    moveLeft = false;
                }
                if (keycode == Input.Keys.UP) {
                    moveUp = false;
                }
                if (keycode == Input.Keys.DOWN) {
                    moveDown = false;
                }

                return false;
            }

        });

    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }

    //Passes x and y coordinates
    public float getX() {
        return x;
    }


    public float getY(){ return y; }



    @Override
    public void draw(Batch batch, float parentAlpha) {

        //Movements are performed/drawn here
        //
        //If true, move.
        if(moveLeft)
            sprite.translateX(-3f);
        if(moveRight)
            sprite.translateX(3f);
        if(moveUp)
            sprite.translateY(3f);
        if(moveDown)
            sprite.translateY(-3f);

        this.x = sprite.getX();
        this.y = sprite.getY();


        //Draws sprite on screen
        sprite.draw(batch);

        //
        //System.out.println("X: "+sprite.getX()+ " Y: "+sprite.getY());


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
